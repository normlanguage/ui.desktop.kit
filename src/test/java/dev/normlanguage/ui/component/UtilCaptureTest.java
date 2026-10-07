package dev.normlanguage.ui.component;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.jupiter.api.Assertions.*;

class UtilCaptureTest extends FxTest {
    @Test void waitsForVisibleImageBeforeCompletingSnapshot() throws Exception {
        var destination = Files.createTempFile("norm-image-capture", ".png");
        var completed = new CompletableFuture<String>();
        var stage = new AtomicReference<Stage>();
        var image = new AtomicReference<Image>();
        try {
            fx(() -> {
                var control = new Image("dev/normlanguage/ui/component/gallery/images/alpine-lake.png");
                image.set(control);
                var root = new StackPane(control);
                var window = new Stage();
                stage.set(window);
                window.setScene(new Scene(root, 700, 500));
                window.show();
                dev.normlanguage.ui.gallery.GallerySupport.capture(window.getScene(), destination, 700, 500,
                        () -> completed.complete(""), completed::complete);
            });
            assertEquals("", completed.get(10, TimeUnit.SECONDS));
            fx(() -> assertEquals(1.0, image.get().getImageView().getImage().getProgress()));
            var captured = javax.imageio.ImageIO.read(destination.toFile());
            assertNotNull(captured);
            assertTrue(captured.getWidth() == 700 && captured.getHeight() == 500);
            var colors = new java.util.HashSet<Integer>();
            for (int y = 100; y < 400; y += 20)
                for (int x = 100; x < 600; x += 20) colors.add(captured.getRGB(x, y));
            assertTrue(colors.size() > 20, "The loaded photograph must appear in the snapshot");
        } finally {
            fx(() -> { if (stage.get() != null) stage.get().close(); });
            Files.deleteIfExists(destination);
        }
    }
}
