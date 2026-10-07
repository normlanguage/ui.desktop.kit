package dev.normlanguage.ui.component;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.css.PseudoClass;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest extends FxTest {
    @Test void projectedUiPreferencesOverrideAncestorAndReleaseSubscriptions() throws Exception {
        fx(() -> {
            var label = new Label("content");
            var local = new ConfigProvider(label);
            var outer = new ConfigProvider(new javafx.scene.layout.VBox(local));
            var configured = new ComponentConfig("Ancestor", 18, ComponentConfig.Density.COMPACT,
                    9, true, Locale.FRANCE);
            outer.setConfig(configured);
            var scene = new Scene(outer);
            var updates = new java.util.concurrent.atomic.AtomicInteger();
            var connection = new ConfigurationConnection(label, updates::incrementAndGet);
            connection.connect();
            KitEnvironment.apply(label, "Projected", 20, false);
            var projected = ConfigurationConnection.resolve(label);
            assertEquals("Projected", projected.fontFamily());
            assertEquals(20, projected.fontSize());
            assertFalse(projected.motionEnabled());
            assertEquals(configured.density(), projected.density());
            assertEquals(configured.radius(), projected.radius());
            assertEquals(configured.locale(), projected.locale());
            assertNull(local.getConfig());
            outer.setConfig(new ComponentConfig("Changed ancestor", 22, ComponentConfig.Density.SPACIOUS,
                    13, true, Locale.GERMANY));
            var inheritedUpdate = ConfigurationConnection.resolve(label);
            assertEquals(13, inheritedUpdate.radius());
            assertEquals(ComponentConfig.Density.SPACIOUS, inheritedUpdate.density());
            assertEquals(Locale.GERMANY, inheritedUpdate.locale());
            assertEquals("Projected", inheritedUpdate.fontFamily());
            assertFalse(inheritedUpdate.motionEnabled());
            var motion = new Motion(label);
            motion.animate(Motion.STANDARD, new javafx.animation.KeyValue(label.opacityProperty(), 0.4));
            assertEquals(0.4, label.getOpacity());
            assertTrue(updates.get() > 1);
            var before = updates.get();
            label.getProperties().put("unrelated", true);
            assertEquals(before, updates.get());
            connection.close();
            KitEnvironment.clear(label);
            assertEquals(outer.getConfig(), ConfigurationConnection.resolve(label));
            assertEquals(before, updates.get());
            motion.close();
            outer.close();
        });
    }

    @Test void clearingLocalThemeDisconnectsAndRestoresInheritance() throws Exception {
        fx(() -> {
            var provider = new ConfigProvider(new Label("Content"));
            var detached = new java.util.concurrent.atomic.AtomicInteger();
            var stage = new Stage();
            stage.setScene(new Scene(provider));
            provider.connectTheme(receiver -> { receiver.accept("-fx-accent: red;"); return detached::incrementAndGet; });
            assertFalse(provider.getThemeCss().isBlank());
            provider.clearTheme();
            assertEquals(1, detached.get());
            assertEquals("", provider.getThemeCss());
            provider.close();
            assertEquals(1, detached.get());
            stage.close();
        });
    }

    @Test void defaultsMatchCurrentComponentGeometry() throws Exception {
        fx(() -> {
            var config = ComponentConfig.defaults();
            assertEquals("System", config.fontFamily());
            assertEquals(14, config.fontSize());
            assertEquals(ComponentConfig.Density.STANDARD, config.density());
            assertEquals(6, config.radius());
            assertTrue(config.motionEnabled());
            assertEquals(Locale.getDefault(), config.locale());
            assertEquals(config, ComponentConfig.defaults());
        });
    }

    @Test void invalidGeometryAndCssControlCharactersAreRejected() {
        assertThrows(IllegalArgumentException.class, () -> new ComponentConfig("", 14,
                ComponentConfig.Density.STANDARD, 6, true, Locale.ENGLISH));
        assertThrows(IllegalArgumentException.class, () -> new ComponentConfig("System", 0,
                ComponentConfig.Density.STANDARD, 6, true, Locale.ENGLISH));
        assertThrows(IllegalArgumentException.class, () -> new ComponentConfig("System", 14,
                ComponentConfig.Density.STANDARD, Double.NaN, true, Locale.ENGLISH));
        assertThrows(NullPointerException.class, () -> new ComponentConfig("System", 14,
                null, 6, true, Locale.ENGLISH));
    }

    @Test void cssDeclarationsResolveInRealJavafxScene() throws Exception {
        fx(() -> {
            var config = new ComponentConfig("Noto Sans CJK SC", 16,
                    ComponentConfig.Density.COMPACT, 12, false, Locale.SIMPLIFIED_CHINESE);
            var label = new Label("Content");
            var app = new App(label);
            app.setConfig(config);
            var stage = new Stage();
            stage.setScene(new Scene(app, 250, 120));
            stage.show();
            try {
                app.applyCss();
                assertEquals(16, label.getFont().getSize());
                assertEquals(0.85, config.density().scale());
                assertEquals(12, config.radius());
                assertFalse(config.motionEnabled());
                assertEquals(Locale.SIMPLIFIED_CHINESE, config.locale());
            } finally { app.close(); stage.close(); }
        });
    }

    @Test void scopedGeneratedStylesheetCanSetConcreteControlGeometry() throws Exception {
        fx(() -> {
            var label = new Label("Geometry");
            label.getStyleClass().add("generated-geometry-test");
            var app = new App(label);
            String css = ".generated-geometry-test { -fx-background-color: red; -fx-background-radius: 12px; }";
            app.getStylesheets().add("data:text/css;base64," + java.util.Base64.getEncoder()
                    .encodeToString(css.getBytes(java.nio.charset.StandardCharsets.UTF_8)));
            var stage = new Stage();
            stage.setScene(new Scene(app, 250, 120));
            stage.show();
            try {
                app.applyCss();
                assertEquals(12, label.getBackground().getFills().getFirst().getRadii().getTopLeftHorizontalRadius());
            } finally { app.close(); stage.close(); }
        });
    }

    @Test void scopedConfigurationOverridesAndReturnsToAncestor() throws Exception {
        fx(() -> {
            var outerButton = new Button("Outer");
            var innerButton = new Button("Inner");
            var local = new ConfigProvider(innerButton);
            var app = new App(new javafx.scene.layout.VBox(outerButton, local));
            var outer = new ComponentConfig("System", 16, ComponentConfig.Density.STANDARD,
                    6, true, Locale.ENGLISH);
            var inner = new ComponentConfig("System", 12, ComponentConfig.Density.COMPACT,
                    12, false, Locale.SIMPLIFIED_CHINESE);
            app.setConfig(outer);
            local.setConfig(inner);
            var stage = new Stage();
            stage.setScene(new Scene(app, 300, 200));
            stage.show();
            try {
                app.applyCss();
                assertEquals(6, outerButton.getBackground().getFills().getFirst().getRadii().getTopLeftHorizontalRadius());
                assertEquals(12, innerButton.getBackground().getFills().getFirst().getRadii().getTopLeftHorizontalRadius());
                assertEquals(12, innerButton.getFont().getSize());
                assertEquals(inner, local.getEffectiveConfig());
                local.setConfig(null);
                app.applyCss();
                assertEquals(outer, local.getEffectiveConfig());
                assertEquals(16, innerButton.getFont().getSize());
                assertEquals(6, innerButton.getBackground().getFills().getFirst().getRadii().getTopLeftHorizontalRadius());
            } finally { app.close(); local.close(); stage.close(); }
        });
    }

    @Test void themeAndConfigurationUpdatesKeepIndependentSources() throws Exception {
        fx(() -> {
            var app = new App(new Button("Action"));
            app.setConfig(new ComponentConfig("System", 18, ComponentConfig.Density.SPACIOUS,
                    10, true, Locale.ENGLISH));
            assertFalse(app.getPseudoClassStates().contains(PseudoClass.getPseudoClass("themed")));
            app.setThemeCss("-norm-canvas: #111111;");
            assertTrue(app.getPseudoClassStates().contains(PseudoClass.getPseudoClass("themed")));
            assertTrue(app.getStyle().contains("#111111"));
            assertTrue(app.getStyle().contains("18.0px"));
            app.setThemeCss("");
            assertFalse(app.getPseudoClassStates().contains(PseudoClass.getPseudoClass("themed")));
            assertTrue(app.getStyle().contains("18.0px"));
            app.close();
        });
    }

    @Test void popupFollowsNearestConfigurationWhileOpen() throws Exception {
        fx(() -> {
            var anchor = new Button("Open");
            var local = new ConfigProvider(anchor);
            var first = new ComponentConfig("System", 12, ComponentConfig.Density.COMPACT,
                    9, false, Locale.ENGLISH);
            var second = new ComponentConfig("System", 18, ComponentConfig.Density.SPACIOUS,
                    15, true, Locale.ENGLISH);
            local.setConfig(first);
            var app = new App(local);
            var stage = new Stage();
            stage.setScene(new Scene(app, 250, 120));
            stage.show();
            try {
                var popup = new Popover(anchor, new Label("Details"));
                popup.show();
                assertEquals(first, popup.getContentRoot().getEffectiveConfig());
                local.setConfig(second);
                assertEquals(second, popup.getContentRoot().getEffectiveConfig());
                popup.close();
            } finally { app.close(); stage.close(); }
        });
    }

    @Test void inheritedMotionStopsAndResumesAnimations() throws Exception {
        fx(() -> {
            var carousel = new Carousel(java.util.List.of(new Label("one"), new Label("two")));
            carousel.setAutoPlay(true);
            var beam = new BorderBeam(new Label("animated"));
            var local = new ConfigProvider(new javafx.scene.layout.VBox(carousel, beam));
            var app = new App(local);
            var still = new ComponentConfig("System", 14, ComponentConfig.Density.STANDARD,
                    6, false, Locale.ENGLISH);
            var moving = new ComponentConfig("System", 14, ComponentConfig.Density.STANDARD,
                    6, true, Locale.ENGLISH);
            local.setConfig(still);
            var stage = new Stage();
            stage.setScene(new Scene(app, 250, 160));
            stage.show();
            try {
                assertFalse(carousel.isPlaying());
                assertFalse(beam.isAnimating());
                local.setConfig(moving);
                assertTrue(carousel.isPlaying());
                assertTrue(beam.isAnimating());
                local.setConfig(still);
                assertFalse(carousel.isPlaying());
                assertFalse(beam.isAnimating());
            } finally { carousel.close(); beam.close(); app.close(); stage.close(); }
        });
    }
}
