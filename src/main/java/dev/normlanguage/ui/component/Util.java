package dev.normlanguage.ui.component;

import javafx.application.Platform;
import javafx.scene.Node;

public final class Util {
    private Util() {}
    public static void style(Node node, String css) { node.setStyle(css); }
    public static <T> java.util.List<T> emptyItems() { return new java.util.ArrayList<>(); }
    public static void requireFxThread() {
        if (!Platform.isFxApplicationThread()) throw new IllegalStateException("JavaFX application thread required");
    }
    public static App app(Node node) {
        for (Node current = node; current != null; current = current.getParent()) {
            if (current instanceof App app) {
                if (app.isClosed()) throw new IllegalStateException("Component root is closed");
                return app;
            }
        }
        throw new IllegalStateException("Node must belong to an App");
    }
    public static void closeTree(Node node) {
        Util.requireFxThread();
        RuntimeException failure = null;
        if (node instanceof javafx.scene.Parent parent && !(node instanceof ConfigProvider)) {
            for (Node child : java.util.List.copyOf(parent.getChildrenUnmodifiable())) {
                try { closeTree(child); }
                catch (RuntimeException error) {
                    if (failure == null) failure = error; else failure.addSuppressed(error);
                }
            }
        }
        try { closeNode(node); }
        catch (RuntimeException error) {
            if (failure == null) failure = error; else failure.addSuppressed(error);
        }
        if (failure != null) throw failure;
    }
    public static void closeNode(Node node) {
        requireFxThread();
        if (node instanceof AutoCloseable resource) {
            try { resource.close(); }
            catch (Exception error) { throw new IllegalStateException("Component cleanup failed", error); }
        }
    }
}
