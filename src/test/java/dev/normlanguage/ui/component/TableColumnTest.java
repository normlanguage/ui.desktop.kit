package dev.normlanguage.ui.component;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TableColumnTest extends FxTest {
    record Order(int amount, String label) {}
    @Test void stableIdentityPreservesNumericSortAcrossTranslatedHeadings() throws Exception {
        fx(() -> {
            var table = new Table<Order>();
            var low = new Order(2, "$2");
            var high = new Order(10, "$10");
            DisplayAdapter.rows(table, List.of(high, low));
            var link = new TableSortLink<>(table);
            link.columns(List.of(new TableColumnSpec<Order>("amount", "Amount", Order::label,
                    (a, b) -> Integer.compare(a.amount(), b.amount()), false)));
            link.update(new TableSortState("amount", false), ignored -> {});
            assertEquals(List.of(low, high), table.getItems());
            var column = table.getColumns().getFirst();
            link.columns(List.of(new TableColumnSpec<Order>("amount", "金额", Order::label,
                    (a, b) -> Integer.compare(a.amount(), b.amount()), false)));
            assertSame(column, table.getColumns().getFirst());
            assertEquals("金额", column.getText());
            assertSame(column, table.getSortOrder().getFirst());
            assertEquals(List.of(low, high), table.getItems());
            assertThrows(IllegalArgumentException.class, () -> link.columns(List.of(
                    new TableColumnSpec<Order>("amount", "A", Order::label, null, false),
                    new TableColumnSpec<Order>("amount", "B", Order::label, null, false))));
            assertEquals(1, table.getColumns().size());
            link.close();
        });
    }
    @Test void virtualWidgetCellsPublishSlotsAndReleaseGraphicsOnClose() throws Exception {
        var ready = new java.util.concurrent.CountDownLatch(1);
        var emptied = new java.util.concurrent.CountDownLatch(1);
        var removing = new java.util.concurrent.atomic.AtomicBoolean();
        var reference = new java.util.concurrent.atomic.AtomicReference<Table<Order>>();
        var window = new java.util.concurrent.atomic.AtomicReference<javafx.stage.Stage>();
        var graphics = new java.util.ArrayList<javafx.scene.Node>();
        fx(() -> {
            var table = new Table<Order>();
            reference.set(table);
            DisplayAdapter.rows(table, List.of(new Order(2, "Two"), new Order(10, "Ten")));
            DisplayAdapter.tableColumns(table, List.of(new TableColumnSpec<>("amount", "Amount", Order::label, null, true)));
            table.cellSlots(slots -> {
                if (slots.isEmpty()) {
                    if (removing.get()) emptied.countDown();
                    return;
                }
                graphics.clear();
                for (var slot : slots) graphics.add(new javafx.scene.control.Label(slot.row().label()));
                table.cellNodes(graphics);
                assertTrue(slots.stream().allMatch(slot -> slot.columnId().equals("amount")));
                ready.countDown();
            });
            var stage = new javafx.stage.Stage();
            window.set(stage);
            stage.setScene(new javafx.scene.Scene(table, 300, 200));
            stage.show();
        });
        assertTrue(ready.await(10, java.util.concurrent.TimeUnit.SECONDS));
        fx(() -> {
            assertFalse(graphics.isEmpty());
            assertTrue(graphics.stream().allMatch(node -> node.getParent() != null));
            DisplayAdapter.tableColumns(reference.get(), List.of(new TableColumnSpec<>("amount", "Translated", Order::label, null, true)));
            reference.get().applyCss();
            reference.get().layout();
            removing.set(true);
            DisplayAdapter.rows(reference.get(), List.of());
            reference.get().cellSlots(slots -> {
                assertTrue(slots.isEmpty());
                emptied.countDown();
            });
        });
        assertTrue(emptied.await(10, java.util.concurrent.TimeUnit.SECONDS));
        fx(() -> {
            reference.get().close();
            assertTrue(graphics.stream().allMatch(node -> node.getParent() == null));
            window.get().close();
        });
    }

}
