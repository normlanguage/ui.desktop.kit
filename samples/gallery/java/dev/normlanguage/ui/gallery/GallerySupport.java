package dev.normlanguage.ui.gallery;

import javafx.scene.Node;

public final class GallerySupport {
    private GallerySupport() {}
    private static void requireFxThread() {
        if (!javafx.application.Platform.isFxApplicationThread()) throw new IllegalStateException("JavaFX application thread required");
    }
    public static String resourceText(String path) throws java.io.IOException {
        try (var input = java.util.Objects.requireNonNull(GallerySupport.class.getResourceAsStream(path), "Resource not found: " + path)) {
            return new String(input.readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
        }
    }
    public static javafx.scene.control.Button requireButton(javafx.scene.Scene scene, String text) {
        return requireControl(scene, text, javafx.scene.control.Button.class);
    }
    private static <T extends javafx.scene.control.Labeled> T requireControl(javafx.scene.Scene scene, String text, Class<T> type) {
        requireFxThread();
        T match = null;
        var pending = new java.util.ArrayDeque<Node>();
        pending.add(scene.getRoot());
        while (!pending.isEmpty()) {
            var current = pending.removeFirst();
            if (type.isInstance(current) && text.equals(type.cast(current).getText())) {
                if (match != null) throw new IllegalStateException("Multiple controls have text: " + text);
                match = type.cast(current);
            }
            if (current instanceof javafx.scene.Parent parent) pending.addAll(parent.getChildrenUnmodifiable());
        }
        if (match == null) throw new IllegalStateException("Control not found: " + text);
        return match;
    }
    public static void capture(javafx.scene.Scene scene, java.nio.file.Path path, int width, int height,
                               Runnable completed, java.util.function.Consumer<String> failed) {
        requireFxThread();
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Snapshot dimensions must be positive");
        new Capture(scene, path, width, height, completed, failed).begin();
    }
    private static final class Capture {
        private final javafx.scene.Scene scene;
        private final java.nio.file.Path path;
        private final int width;
        private final int height;
        private final Runnable completed;
        private final java.util.function.Consumer<String> failed;
        private final java.util.IdentityHashMap<javafx.scene.image.Image, PendingImage> pending = new java.util.IdentityHashMap<>();
        private boolean finished;

        private Capture(javafx.scene.Scene scene, java.nio.file.Path path, int width, int height,
                        Runnable completed, java.util.function.Consumer<String> failed) {
            this.scene = scene;
            this.path = path;
            this.width = width;
            this.height = height;
            this.completed = completed;
            this.failed = failed;
        }

        private void begin() {
            var nodes = new java.util.ArrayDeque<Node>();
            nodes.add(scene.getRoot());
            while (!nodes.isEmpty()) {
                var node = nodes.removeFirst();
                if (node instanceof javafx.scene.image.ImageView view && view.getImage() != null) {
                    var image = view.getImage();
                    if (image.isError()) {
                        fail(image.getException());
                        return;
                    }
                    if (image.getProgress() < 1 && !pending.containsKey(image)) {
                        javafx.beans.value.ChangeListener<Number> progress = (observable, previous, next) -> ready(image);
                        javafx.beans.value.ChangeListener<Boolean> error = (observable, previous, next) -> ready(image);
                        pending.put(image, new PendingImage(progress, error));
                        image.progressProperty().addListener(progress);
                        image.errorProperty().addListener(error);
                    }
                }
                if (node instanceof javafx.scene.Parent parent) nodes.addAll(parent.getChildrenUnmodifiable());
            }
            if (pending.isEmpty()) snapshot();
        }

        private void ready(javafx.scene.image.Image image) {
            if (finished) return;
            if (image.isError()) {
                fail(image.getException());
                return;
            }
            if (image.getProgress() < 1) return;
            var listeners = pending.remove(image);
            if (listeners != null) {
                image.progressProperty().removeListener(listeners.progress());
                image.errorProperty().removeListener(listeners.error());
            }
            if (pending.isEmpty()) snapshot();
        }

        private void snapshot() {
            if (finished) return;
            var root = scene.getRoot();
            root.resize(width, height);
            root.applyCss();
            root.layout();
            scene.snapshot(result -> {
                if (finished) return null;
                try {
                    var image = result.getImage();
                    var output = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_ARGB);
                    var pixels = image.getPixelReader();
                    for (int y = 0; y < height; y++) {
                        for (int x = 0; x < width; x++) output.setRGB(x, y, pixels.getArgb(x, y));
                    }
                    var parent = path.toAbsolutePath().getParent();
                    if (parent != null) java.nio.file.Files.createDirectories(parent);
                    if (!javax.imageio.ImageIO.write(output, "png", path.toFile())) {
                        throw new java.io.IOException("No PNG image writer is available");
                    }
                } catch (java.io.IOException | RuntimeException error) {
                    fail(error);
                    return null;
                }
                finished = true;
                completed.run();
                return null;
            }, new javafx.scene.image.WritableImage(width, height));
        }

        private void fail(Exception error) {
            finished = true;
            for (var entry : pending.entrySet()) {
                entry.getKey().progressProperty().removeListener(entry.getValue().progress());
                entry.getKey().errorProperty().removeListener(entry.getValue().error());
            }
            pending.clear();
            failed.accept(String.valueOf(error));
        }

        private record PendingImage(javafx.beans.value.ChangeListener<Number> progress,
                                    javafx.beans.value.ChangeListener<Boolean> error) {}
    }
}
