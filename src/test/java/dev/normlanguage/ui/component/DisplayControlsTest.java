package dev.normlanguage.ui.component;

import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TreeItem;
import javafx.beans.property.SimpleStringProperty;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class DisplayControlsTest extends FxTest {
    @Test void selectionAndVirtualizationUseRealJavaFxControls() throws Exception {
        fx(() -> {
            var list = new Listy<String>();
            list.getItems().addAll("one", "two");
            list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            list.getSelectionModel().select(1);
            assertEquals("two", list.getSelectionModel().getSelectedItem());
            var table = new Table<String>();
            table.getItems().add("row");
            var column = table.column("Value", value -> value);
            assertEquals("Value", column.getText());
            assertEquals("row", column.getCellData(0));
            var tree = new Tree<String>("root");
            tree.getRoot().getChildren().add(new javafx.scene.control.TreeItem<>("child"));
            assertEquals("child", tree.getRoot().getChildren().getFirst().getValue());
        });
    }

    @Test void navigationAndStateAreInteractive() throws Exception {
        fx(() -> {
            var carousel = new Carousel(List.of(new Label("a"), new Label("b")));
            carousel.next();
            assertEquals(1, carousel.getIndex());
            carousel.next();
            assertEquals(0, carousel.getIndex());
            var collapse = new Collapse("Details", new Label("Body"));
            collapse.setExpanded(true);
            assertTrue(collapse.isExpanded());
            var segmented = new Segmented<String>(List.of("A", "B"));
            segmented.setValue("B");
            assertEquals("B", segmented.getValue());
        });
    }

    @Test void dataAndMediaAreUsable() throws Exception {
        fx(() -> {
            var calendar = new Calendar();
            calendar.setValue(LocalDate.of(2026, 10, 2));
            assertEquals(LocalDate.of(2026, 10, 2), calendar.getValue());
            assertEquals(YearMonth.of(2026, 10), calendar.getDisplayedMonth());
            calendar.nextMonth();
            assertEquals(YearMonth.of(2026, 11), calendar.getDisplayedMonth());
            var qr = new QRCode("https://normlanguage.dev", 128);
            var pixels = qr.getImage();
            assertEquals(128, (int) pixels.getWidth());
            assertEquals(128, (int) pixels.getHeight());
            var argb = new int[128 * 128];
            pixels.getPixelReader().getPixels(0, 0, 128, 128, javafx.scene.image.PixelFormat.getIntArgbInstance(), argb, 0, 128);
            try {
                var bitmap = new com.google.zxing.BinaryBitmap(new com.google.zxing.common.HybridBinarizer(new com.google.zxing.RGBLuminanceSource(128, 128, argb)));
                assertEquals("https://normlanguage.dev", new com.google.zxing.MultiFormatReader().decode(bitmap).getText());
            } catch (com.google.zxing.NotFoundException error) { fail(error); }
            var tag = new Tag("stable");
            tag.setClosable(true);
            assertTrue(tag.isClosable());
        });
    }

    @Test void carouselStopsItsTimerWhenRemovedFromScene() throws Exception {
        fx(() -> {
            var carousel = new Carousel(List.of(new Label("one"), new Label("two")));
            var root = new StackPane(carousel);
            var stage = new javafx.stage.Stage();
            stage.setScene(new Scene(root));
            stage.show();
            try {
                carousel.setAutoPlay(true);
                assertTrue(carousel.isPlaying());
                root.getChildren().clear();
                assertFalse(carousel.isPlaying());
            } finally { carousel.close(); stage.close(); }
        });
    }

    @Test void tableFiltersSortsAndEditsTypedRows() throws Exception {
        fx(() -> {
            record Row(SimpleStringProperty name) {}
            var rows = FXCollections.observableArrayList(new Row(new SimpleStringProperty("z")), new Row(new SimpleStringProperty("a")));
            var table = new Table<Row>();
            table.setSource(rows);
            var column = table.observableColumn("Name", row -> row.name());
            column.setSortType(javafx.scene.control.TableColumn.SortType.ASCENDING);
            table.getSortOrder().add(column);
            assertEquals("a", table.getItems().getFirst().name().get());
            table.setPredicate(row -> !row.name().get().equals("z"));
            assertEquals(1, table.getItems().size());
            var editable = table.editableColumn("Edit", row -> row.name(), (row, value) -> row.name().set(value));
            editable.getOnEditCommit().handle(new javafx.scene.control.TableColumn.CellEditEvent<>(table, new javafx.scene.control.TablePosition<>(table, 0, editable), javafx.scene.control.TableColumn.editCommitEvent(), "edited"));
            assertEquals("edited", rows.get(1).name().get());
        });
    }

    @Test void treeLoadsChildrenAndSupportsChecks() throws Exception {
        var holder = new java.util.concurrent.atomic.AtomicReference<Tree<String>>();
        var children = new CompletableFuture<List<String>>();
        var projected = new CompletableFuture<Void>();
        fx(() -> {
            var tree = new Tree<String>("root");
            holder.set(tree);
            new Scene(new StackPane(tree));
            tree.getRoot().setExpanded(false);
            tree.getRoot().getChildren().addListener((ListChangeListener<TreeItem<String>>) change -> {
                while (change.next()) if (change.wasAdded()) projected.complete(null);
            });
            tree.loadErrorProperty().addListener((observable, previous, error) -> {
                if (error != null) projected.completeExceptionally(error);
            });
            tree.setLazyChildren(value -> value.equals("root") ? children : CompletableFuture.completedFuture(List.of()));
            tree.setCheckable(true);
            tree.getRoot().setExpanded(true);
        });
        assertFalse(projected.isDone());
        children.complete(List.of("child"));
        projected.get(20, TimeUnit.SECONDS);
        fx(() -> {
            var tree = holder.get();
            assertEquals("child", tree.getRoot().getChildren().getFirst().getValue());
            ((javafx.scene.control.CheckBoxTreeItem<String>) tree.getRoot().getChildren().getFirst()).setSelected(true);
            assertTrue(tree.getCheckedValues().contains("child"));
        });
    }

    @Test void treeIgnoresResultsFromDetachedLoad() throws Exception {
        var pending = new CompletableFuture<List<String>>();
        var treeHolder = new java.util.concurrent.atomic.AtomicReference<Tree<String>>();
        var rootHolder = new java.util.concurrent.atomic.AtomicReference<StackPane>();
        fx(() -> {
            var tree = new Tree<String>("root");
            var root = new StackPane(tree);
            new Scene(root);
            treeHolder.set(tree);
            rootHolder.set(root);
            tree.setLazyChildren(value -> pending);
            root.getChildren().clear();
            pending.complete(List.of("stale"));
        });
        fx(() -> assertTrue(treeHolder.get().getRoot().getChildren().isEmpty()));
    }

    @Test void imageCancelsOnDetachAndLoadsAgainOnRemount() throws Exception {
        var source = DisplayControlsTest.class.getResource("image.png").toExternalForm();
        fx(() -> {
            var image = new Image(source);
            var root = new StackPane(image);
            new Scene(root);
            var first = image.getImageView().getImage();
            assertNotNull(first);
            root.getChildren().clear();
            assertNull(image.getImageView().getImage());
            root.getChildren().add(image);
            assertNotNull(image.getImageView().getImage());
            assertNotSame(first, image.getImageView().getImage());
        });
    }
}
