package dev.normlanguage.ui.component;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProgressWorkTest extends FxTest {
    @Test void workCountPreservesBoundariesAndRejectsInvalidAmounts() throws Exception {
        fx(() -> {
            var progress = new Progress();
            progress.setWork(0, 200);
            assertEquals(0.0, progress.getProgress());
            progress.setWork(50, 200);
            assertEquals(0.25, progress.getProgress());
            progress.setWork(200, 200);
            assertEquals(1.0, progress.getProgress());
            progress.setWork(Integer.MAX_VALUE, Integer.MAX_VALUE);
            assertEquals(1.0, progress.getProgress());
            assertThrows(IllegalArgumentException.class, () -> progress.setWork(0, 0));
            assertThrows(IllegalArgumentException.class, () -> progress.setWork(-1, 200));
            assertThrows(IllegalArgumentException.class, () -> progress.setWork(201, 200));
            assertEquals(1.0, progress.getProgress());
            progress.setFraction(0.5);
            assertEquals(0.5, progress.getProgress());
            assertThrows(IllegalArgumentException.class, () -> progress.setFraction(Double.NaN));
            assertThrows(IllegalArgumentException.class, () -> progress.setFraction(Double.POSITIVE_INFINITY));
            assertThrows(IllegalArgumentException.class, () -> progress.setFraction(-0.1));
            assertThrows(IllegalArgumentException.class, () -> progress.setFraction(1.1));
            assertEquals(0.5, progress.getProgress());
        });
    }
}
