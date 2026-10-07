package dev.normlanguage.ui.component;

import javafx.scene.Node;
import java.util.Objects;

public final class KitEnvironment {
    static final Object KEY = new Object();
    private KitEnvironment() {}

    record Preferences(String fontFamily, double fontSize, boolean motionEnabled) {}

    public static void apply(Node node, String fontFamily, double fontSize, boolean motionEnabled) {
        Util.requireFxThread();
        Objects.requireNonNull(node);
        var defaults = ComponentConfig.defaults();
        new ComponentConfig(fontFamily, fontSize, defaults.density(), defaults.radius(), motionEnabled, defaults.locale());
        node.getProperties().put(KEY, new Preferences(fontFamily, fontSize, motionEnabled));
    }
    public static void clear(Node node) {
        Util.requireFxThread();
        node.getProperties().remove(KEY);
    }
}
