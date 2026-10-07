package dev.normlanguage.ui.component;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class DisplayAdapterTest extends FxTest {
    @Test void contentSlotsPreserveNativeChromeAndRenderedNodes() throws Exception {
        fx(() -> {
            var first = new Label("first");
            var second = new Label("second");
            var badge = new Badge(first);
            DisplayAdapter.badgeContent(badge, second);
            assertSame(second, badge.getChildren().getFirst());
            assertEquals(2, badge.getChildren().size());

            var card = new Card("Heading", first);
            DisplayAdapter.cardContent(card, second);
            assertSame(second, card.getCenter());
            assertNotNull(card.getTop());

            var collapse = new Collapse("Details", first);
            DisplayAdapter.collapseContent(collapse, second);
            assertSame(second, collapse.getContent());
            collapse.close();
        });
    }

    @Test void dataProjectionKeepsControlAndSelectionStable() throws Exception {
        fx(() -> {
            var list = new dev.normlanguage.ui.component.List<String>();
            DisplayAdapter.items(list, List.of("One", "Two"));
            list.getSelectionModel().select("Two");
            DisplayAdapter.items(list, List.of("Two", "Three"));
            assertEquals(List.of("Two", "Three"), list.getItems());
            assertEquals("Two", list.getSelectionModel().getSelectedItem());

            var table = new Table<String>();
            DisplayAdapter.rows(table, List.of("Beta", "Alpha"));
            var column = DisplayAdapter.column(table, "Name", value -> value);
            assertSame(column, table.getColumns().getFirst());
            column.setSortType(TableColumn.SortType.ASCENDING);
            table.getSortOrder().add(column);
            table.sort();
            assertEquals(List.of("Alpha", "Beta"), table.getItems());
            DisplayAdapter.tableColumns(table, List.of(new TableColumnSpec<>("name", "Name", String::toUpperCase, String::compareTo, false)));
            var stable = table.getColumns().getFirst();
            DisplayAdapter.tableColumns(table, List.of(new TableColumnSpec<>("name", "姓名", String::toLowerCase, String::compareTo, false)));
            assertSame(stable, table.getColumns().getFirst());
            assertEquals("姓名", stable.getText());
            assertEquals("Alpha", stable.getCellData("Alpha"));
        });
    }

    @Test void valueLinksPublishUserChangesAndSuppressModelEcho() throws Exception {
        fx(() -> {
            var calendar = new Calendar();
            var changed = new AtomicReference<LocalDate>();
            var link = DisplayAdapter.calendarValue(calendar);
            var initial = LocalDate.of(2025, 4, 12);
            link.update(initial, changed::set);
            assertNull(changed.get());
            calendar.setValue(initial.plusDays(1));
            assertEquals(initial.plusDays(1), changed.get());
            link.close();
            calendar.close();
        });
    }

    @Test void structuredRowsDoNotRetainRemovedNodes() throws Exception {
        fx(() -> {
            var descriptions = new Descriptions();
            var first = new Label("one");
            DisplayAdapter.descriptions(descriptions, List.of("A"), List.of(first));
            assertTrue(descriptions.getChildren().contains(first));
            DisplayAdapter.descriptions(descriptions, List.of("B"), List.of(new Label("two")));
            assertFalse(descriptions.getChildren().contains(first));

            var timeline = new Timeline();
            DisplayAdapter.timeline(timeline, List.of("Today"), List.of(first));
            assertEquals(1, timeline.getChildren().size());
            DisplayAdapter.timeline(timeline, List.of(), List.of());
            assertTrue(timeline.getChildren().isEmpty());
        });
    }

    @Test void galleryImageResourceIsResolvableByComponentSource() throws Exception {
        fx(() -> {
            var image = new javafx.scene.image.Image("dev/normlanguage/ui/component/gallery/images/alpine-lake.png", false);
            assertFalse(image.isError());
            assertTrue(image.getWidth() > 0);
        });
    }
}
