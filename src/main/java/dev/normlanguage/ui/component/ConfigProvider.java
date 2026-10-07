package dev.normlanguage.ui.component;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import java.util.Objects;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class ConfigProvider extends StackPane implements AutoCloseable {
    private final StringProperty themeCss = new SimpleStringProperty(this, "themeCss", "");
    private final ObjectProperty<ComponentConfig> config = new SimpleObjectProperty<>(this, "config");
    private final ConfigurationConnection configuration = new ConfigurationConnection(this, this::refreshStyle);
    private static final PseudoClass THEMED = PseudoClass.getPseudoClass("themed");
    private ComponentConfig appliedConfig;
    private String configStylesheet;
    private String applicationStylesheet;
    private Node content;
    private final ContentOwnership contentOwnership;
    private java.util.function.Function<java.util.function.Consumer<String>, Runnable> themeSource;
    private Runnable disconnectTheme;
    private record Publication(long epoch, String css) {}
    private final Object themeLock = new Object();
    private Publication pendingTheme;
    private volatile long themeEpoch;
    private volatile boolean closed;

    public ConfigProvider() { this(ContentOwnership.OWNED); }
    public ConfigProvider(ContentOwnership ownership) {
        contentOwnership = Objects.requireNonNull(ownership);
        getStyleClass().add("norm-root");
        getStylesheets().add(Objects.requireNonNull(ConfigProvider.class.getResource("components.css")).toExternalForm());
        themeCss.addListener((observable, previous, current) -> refreshStyle());
        sceneProperty().addListener((observable, previous, current) -> refreshSubscription());
        configuration.connect();
    }
    public ConfigProvider(Node content) { this(content, ContentOwnership.OWNED); }
    public ConfigProvider(Node content, ContentOwnership ownership) { this(ownership); setContent(content); }
    public final ContentOwnership getContentOwnership() { return contentOwnership; }
    public final StringProperty themeCssProperty() { return themeCss; }
    public final String getThemeCss() { return themeCss.get(); }
    public final void setThemeCss(String css) { Util.requireFxThread(); themeCss.set(Objects.requireNonNull(css)); }
    public final ObjectProperty<ComponentConfig> configProperty() { return config; }
    public final ComponentConfig getConfig() { return config.get(); }
    public final ComponentConfig getEffectiveConfig() { return ConfigurationConnection.resolve(this); }
    public final void setConfig(ComponentConfig value) {
        Util.requireFxThread();
        if (closed) throw new IllegalStateException("Component scope is closed");
        config.set(value);
    }
    public final Node getContent() { return content; }
    public final void setContent(Node content) {
        Util.requireFxThread();
        if (closed && content != null) throw new IllegalStateException("Component scope is closed");
        if (this.content == content) return;
        getChildren().remove(this.content);
        var previous = this.content;
        this.content = null;
        if (previous != null && contentOwnership == ContentOwnership.OWNED) Util.closeTree(previous);
        this.content = content;
        if (content != null) getChildren().addFirst(content);
    }
    public final boolean isClosed() { return closed; }
    private void refreshStyle() {
        if (closed) return;
        var effective = getEffectiveConfig();
        if (!effective.equals(appliedConfig)) {
            if (configStylesheet != null) getStylesheets().remove(configStylesheet);
            configStylesheet = "data:text/css;base64," + Base64.getEncoder().encodeToString(
                    effective.stylesheet().getBytes(StandardCharsets.UTF_8));
            getStylesheets().add(configStylesheet);
            appliedConfig = effective;
        }
        setStyle(themeCss.get() + effective.toCss());
        pseudoClassStateChanged(THEMED, !themeCss.get().isBlank());
    }
    public final void connectTheme(java.util.function.Function<java.util.function.Consumer<String>, Runnable> subscribe) {
        Util.requireFxThread();
        if (closed) throw new IllegalStateException("Component scope is closed");
        themeSource = Objects.requireNonNull(subscribe);
        refreshSubscription();
    }
    public final void setStylesheet(String resource) {
        Util.requireFxThread();
        var next = resource == null ? null : Objects.requireNonNull(ConfigProvider.class.getResource(resource), "Stylesheet resource not found: " + resource).toExternalForm();
        if (Objects.equals(applicationStylesheet, next)) return;
        if (applicationStylesheet != null) getStylesheets().remove(applicationStylesheet);
        applicationStylesheet = next;
        if (next != null) getStylesheets().add(next);
    }
    public final void clearTheme() {
        Util.requireFxThread();
        if (closed) throw new IllegalStateException("Component scope is closed");
        themeSource = null;
        refreshSubscription();
        setThemeCss("");
    }
    private void refreshSubscription() {
        long epoch;
        synchronized (themeLock) { epoch = ++themeEpoch; pendingTheme = null; }
        if (disconnectTheme != null) { var release = disconnectTheme; disconnectTheme = null; release.run(); }
        if (!closed && getScene() != null && themeSource != null) {
            var release = Objects.requireNonNull(themeSource.apply(css -> publishTheme(epoch, css)));
            if (closed || themeEpoch != epoch) release.run(); else disconnectTheme = release;
        }
    }
    public final void publishTheme(String css) { publishTheme(themeEpoch, css); }
    private void publishTheme(long epoch, String css) {
        Objects.requireNonNull(css);
        if (javafx.application.Platform.isFxApplicationThread()) {
            synchronized (themeLock) {
                if (closed || themeEpoch != epoch) return;
                pendingTheme = null;
            }
            setThemeCss(css);
        } else {
            boolean enqueue;
            synchronized (themeLock) {
                if (closed || themeEpoch != epoch) return;
                enqueue = pendingTheme == null;
                pendingTheme = new Publication(epoch, css);
            }
            if (enqueue) javafx.application.Platform.runLater(() -> {
                Publication latest;
                synchronized (themeLock) {
                    latest = pendingTheme;
                    pendingTheme = null;
                    if (closed || latest == null || latest.epoch() != themeEpoch) return;
                }
                setThemeCss(latest.css());
            });
        }
    }
    @Override public void close() {
        Util.requireFxThread();
        if (closed) return;
        synchronized (themeLock) { closed = true; themeEpoch++; pendingTheme = null; }
        RuntimeException failure = null;
        try { configuration.close(); }
        catch (RuntimeException error) { failure = error; }
        themeSource = null;
        if (disconnectTheme != null) {
            var release = disconnectTheme;
            disconnectTheme = null;
            try { release.run(); }
            catch (RuntimeException error) {
                if (failure == null) failure = error; else failure.addSuppressed(error);
            }
        }
        try { setContent(null); }
        catch (RuntimeException error) {
            if (failure == null) failure = error; else failure.addSuppressed(error);
        }
        if (failure != null) throw failure;
    }
}
