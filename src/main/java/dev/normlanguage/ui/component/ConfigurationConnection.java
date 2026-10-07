package dev.normlanguage.ui.component;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.collections.MapChangeListener;

import java.util.ArrayList;
import java.util.Objects;

final class ConfigurationConnection implements AutoCloseable {
    private final Node anchor;
    private final Runnable changed;
    private final ArrayList<Node> lineage = new ArrayList<>();
    private final ChangeListener<Parent> parentChanged = (observable, old, next) -> rewire();
    private final InvalidationListener configurationChanged;
    private final MapChangeListener<Object, Object> environmentChanged;
    private boolean connected;

    ConfigurationConnection(Node anchor, Runnable changed) {
        this.anchor = Objects.requireNonNull(anchor);
        this.changed = Objects.requireNonNull(changed);
        configurationChanged = observable -> changed.run();
        environmentChanged = change -> { if (change.getKey() == KitEnvironment.KEY) changed.run(); };
    }
    static ComponentConfig resolve(Node anchor) {
        ComponentConfig inherited = null;
        KitEnvironment.Preferences preferences = null;
        for (Node current = anchor; current != null; current = current.getParent()) {
            if (preferences == null && current.getProperties().get(KitEnvironment.KEY) instanceof KitEnvironment.Preferences found)
                preferences = found;
            if (inherited == null && current instanceof ConfigProvider provider && provider.getConfig() != null)
                inherited = provider.getConfig();
        }
        var base = inherited == null ? ComponentConfig.defaults() : inherited;
        return preferences == null ? base : new ComponentConfig(preferences.fontFamily(), preferences.fontSize(),
                base.density(), base.radius(), preferences.motionEnabled(), base.locale());
    }
    void connect() {
        if (connected) return;
        connected = true;
        rewire();
    }
    private void rewire() {
        for (var node : lineage) {
            node.parentProperty().removeListener(parentChanged);
            node.getProperties().removeListener(environmentChanged);
            if (node instanceof ConfigProvider provider) provider.configProperty().removeListener(configurationChanged);
        }
        lineage.clear();
        if (!connected) return;
        for (Node current = anchor; current != null; current = current.getParent()) {
            lineage.add(current);
            current.parentProperty().addListener(parentChanged);
            current.getProperties().addListener(environmentChanged);
            if (current instanceof ConfigProvider provider) provider.configProperty().addListener(configurationChanged);
        }
        changed.run();
    }
    @Override public void close() {
        if (!connected) return;
        connected = false;
        rewire();
    }
}
