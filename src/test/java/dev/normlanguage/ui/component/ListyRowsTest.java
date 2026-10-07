package dev.normlanguage.ui.component;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.jupiter.api.Assertions.*;

class ListyRowsTest extends FxTest {
    @Test void visibleWidgetsFollowRecycledCellsAndCloseReleasesGraphics() throws Exception {
        var rows = new AtomicReference<List<Integer>>(List.of());
        var control = new AtomicReference<Listy<Integer>>();
        var window = new AtomicReference<Stage>();
        var rendered = new AtomicReference<java.util.List<javafx.scene.Node>>();
        fx(() -> {
            var list = new Listy<Integer>();
            list.getItems().addAll(java.util.stream.IntStream.range(0, 10000).boxed().toList());
            list.rows(rows::set);
            var stage = new Stage();
            stage.setScene(new Scene(new StackPane(list), 360, 240));
            stage.show();
            control.set(list);
            window.set(stage);
        });
        fx(() -> {});
        fx(() -> {
            assertFalse(rows.get().isEmpty());
            assertTrue(rows.get().size() < 30);
            var nodes = rows.get().stream().map(value -> new javafx.scene.control.Label("Row " + value)).toList();
            control.get().rowNodes(new ArrayList<>(nodes));
            rendered.set(new ArrayList<>(nodes));
            assertTrue(nodes.stream().anyMatch(node -> node.getParent() != null));
            control.get().refresh();
        });
        fx(() -> {});
        fx(() -> {
            assertTrue(rendered.get().stream().anyMatch(node -> node.getParent() != null));
            control.get().scrollTo(9000);
            control.get().applyCss();
            control.get().layout();
        });
        fx(() -> {});
        fx(() -> {
            assertTrue(rows.get().stream().anyMatch(value -> value >= 9000));
            assertTrue(rows.get().size() < 30);
            control.get().close();
            assertTrue(control.get().lookupAll(".list-cell").stream()
                .filter(javafx.scene.control.ListCell.class::isInstance)
                .map(javafx.scene.control.ListCell.class::cast).allMatch(cell -> cell.getGraphic() == null));
            window.get().close();
        });
    }
}
