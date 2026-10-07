package dev.normlanguage.ui.component;

import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TableColumn;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisplayStateLinkTest extends FxTest {
    @Test void tableSortIsTypedBidirectionalAndSurvivesColumnRefresh() throws Exception {
        fx(() -> {
            var table = new Table<String>();
            DisplayAdapter.rows(table, List.of("Beta", "Alpha"));
            var link = new TableSortLink<>(table);
            link.columns(List.of(new TableColumnSpec<>("name", "Name", row -> row, String::compareTo, false)));
            var changes = new ArrayList<TableSortState>();
            link.update(new TableSortState("name", false), changes::add);
            assertEquals(List.of("Alpha", "Beta"), table.getItems());
            assertTrue(changes.isEmpty());
            var column = table.getColumns().getFirst();
            link.columns(List.of(new TableColumnSpec<>("name", "姓名", String::toUpperCase, String::compareTo, false)));
            assertSame(column, table.getColumns().getFirst());
            column.setSortType(TableColumn.SortType.DESCENDING);
            assertEquals(new TableSortState("name", true), changes.getLast());
            link.unbind();
            column.setSortType(TableColumn.SortType.ASCENDING);
            assertEquals(1, changes.size());
            link.update(new TableSortState("name", false), changes::add);
            column.setSortType(TableColumn.SortType.DESCENDING);
            assertEquals(2, changes.size());
            link.close();
            column.setSortType(TableColumn.SortType.ASCENDING);
            assertEquals(2, changes.size());
        });
    }

    @Test void treeChecksRoundTripAndRewireWhenModelChanges() throws Exception {
        fx(() -> {
            var tree = new Tree<String>("Root");
            DisplayAdapter.treeChildren(tree, value -> value.equals("Root") ? List.of("A", "B") : List.of());
            var link = new TreeCheckLink<>(tree);
            var changes = new ArrayList<List<String>>();
            link.update(List.of("A"), changes::add);
            assertEquals(List.of("A"), tree.getCheckedValues());
            assertTrue(changes.isEmpty());
            var b = (CheckBoxTreeItem<String>) tree.getRoot().getChildren().get(1);
            b.setSelected(true);
            assertTrue(changes.getLast().contains("B"));
            DisplayAdapter.treeChildren(tree, value -> value.equals("Root") ? List.of("A", "C") : List.of());
            link.update(List.of("C"), changes::add);
            assertEquals(List.of("C"), tree.getCheckedValues());
            int beforeUnbind = changes.size();
            link.unbind();
            ((CheckBoxTreeItem<String>) tree.getRoot().getChildren().get(1)).setSelected(false);
            assertEquals(beforeUnbind, changes.size());
            link.close();
            int before = changes.size();
            ((CheckBoxTreeItem<String>) tree.getRoot().getChildren().get(1)).setSelected(false);
            assertEquals(before, changes.size());
        });
    }
}
