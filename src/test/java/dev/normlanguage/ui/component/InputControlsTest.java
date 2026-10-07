package dev.normlanguage.ui.component;

import javafx.scene.control.TreeItem;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.math.BigDecimal;
import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class InputControlsTest extends FxTest {
    @Test void nativeEditorsKeepTheirJavaFxState() throws Exception {
        fx(() -> {
            var checkbox = new Checkbox("Agree");
            checkbox.setSelected(true);
            assertTrue(checkbox.isSelected());
            var date = new DatePicker();
            date.setValue(java.time.LocalDate.of(2026, 10, 2));
            assertEquals(2, date.getValue().getDayOfMonth());
            var color = new ColorPicker();
            color.setValue(javafx.scene.paint.Color.color(0.2, 0.4, 0.6, 0.25));
            assertEquals(0.25, color.getAlphaSlider().getValue());
            color.getAlphaSlider().setValue(0.5);
            assertEquals(0.5, color.getValue().getOpacity());
            var number = new InputNumber();
            number.setValue(4.5);
            assertEquals(new BigDecimal("4.5"), number.getValue());
            assertInstanceOf(javafx.scene.control.PasswordField.class, Input.password());
            assertInstanceOf(javafx.scene.control.TextArea.class, Input.multiline());
            var select = new Select<String>();
            select.getItems().addAll("a", "b");
            select.setValue("b");
            assertEquals("b", select.getValue());
            var time = new TimePicker();
            time.setValue(LocalTime.of(9, 30));
            assertEquals(LocalTime.of(9, 30), time.getValue());
        });
    }

    @Test void decimalEditingRetainsDraftAndCommitsExactValues() throws Exception {
        fx(() -> {
            var number = new InputNumber(new BigDecimal("-10"), new BigDecimal("10"), BigDecimal.ZERO, new BigDecimal("0.25"));
            number.setScale(2);
            number.getEditor().setText("-");
            assertEquals(BigDecimal.ZERO.setScale(2), number.getValue());
            number.getEditor().setText("-.");
            assertEquals("-.", number.getEditor().getText());
            number.getEditor().setText("1.235");
            number.getEditor().fireEvent(new javafx.event.ActionEvent());
            assertEquals(new BigDecimal("1.24"), number.getValue());
            number.increment();
            assertEquals(new BigDecimal("1.49"), number.getValue());
            number.getEditor().setText("11");
            number.getEditor().fireEvent(new javafx.event.ActionEvent());
            assertEquals(new BigDecimal("1.49"), number.getValue());
            assertFalse(number.isDraftValid());
        });
    }

    @Test void invalidDecimalDraftRestoresCommittedValueOnBlur() throws Exception {
        fx(() -> {
            var number = new InputNumber(new BigDecimal("-10"), new BigDecimal("10"), new BigDecimal("2.50"), new BigDecimal("0.25"));
            var next = new javafx.scene.control.Button("Next");
            var stage = new Stage();
            stage.setScene(new Scene(new VBox(number, next), 300, 120));
            stage.show();
            try {
                number.getEditor().requestFocus();
                number.getEditor().setText("-.");
                next.requestFocus();
                assertEquals(new BigDecimal("2.50"), number.getValue());
                assertEquals("2.50", number.getEditor().getText());
                assertTrue(number.isDraftValid());
            } finally { stage.close(); }
        });
    }

    @Test void hierarchyAndTransferUseTypedValues() throws Exception {
        fx(() -> {
            var first = new Cascader.Item<>("region", "Region", List.of(new Cascader.Item<>("city", "City", List.of())));
            var cascade = new Cascader<>(List.of(first));
            cascade.selectPath(List.of("region", "city"));
            assertEquals(List.of("region", "city"), cascade.getValue());
            var root = new TreeItem<>("root");
            root.getChildren().add(new TreeItem<>("leaf"));
            var tree = new TreeSelect<>(root);
            tree.select(root.getChildren().getFirst());
            assertEquals("leaf", tree.getSelectedValue());
            var transfer = new Transfer<>(List.of("a", "b", "c"));
            transfer.select("b");
            assertEquals(List.of("b"), List.copyOf(transfer.getSelectedItems()));
            assertEquals(List.of("a", "c"), List.copyOf(transfer.getAvailableItems()));
        });
    }

    @Test void selectionAndRangesPreserveTypedBounds() throws Exception {
        fx(() -> {
            var choices = javafx.collections.FXCollections.observableArrayList("Alpha", "Beta", "Gamma");
            var searchable = Select.searchable(choices);
            searchable.getSearchField().setText("ga");
            assertEquals(List.of("Gamma"), List.copyOf(searchable.getSelect().getItems()));
            var multiple = Select.multiple(choices);
            multiple.select("Alpha");
            multiple.select("Gamma");
            multiple.getSearchField().setText("ga");
            assertEquals(List.of("Alpha", "Gamma"), List.copyOf(multiple.getSelectedItems()));
            var rangeSlider = new Slider.Range(0, 100, 20, 80);
            rangeSlider.getStartSlider().setValue(90);
            assertEquals(80, rangeSlider.getStart());
            rangeSlider.setRange(10, 70);
            assertEquals(70, rangeSlider.getEnd());
            var rangeDate = new DatePicker.Range();
            rangeDate.setValue(new DatePicker.DateRange(java.time.LocalDate.of(2026, 1, 1), java.time.LocalDate.of(2026, 1, 31)));
            rangeDate.getStartPicker().setValue(java.time.LocalDate.of(2026, 2, 1));
            assertEquals(java.time.LocalDate.of(2026, 2, 1), rangeDate.getValue().end());
            var time = new TimePicker(30);
            time.setAllowedRange(LocalTime.of(9, 0), LocalTime.of(10, 0));
            assertEquals(List.of(LocalTime.of(9, 0), LocalTime.of(9, 30), LocalTime.of(10, 0)), List.copyOf(time.getItems()));
        });
    }

    @Test void cascaderLoadsChildrenOnDemand() throws Exception {
        var ready = new CountDownLatch(1);
        var ref = new AtomicReference<Cascader<String>>();
        fx(() -> {
            var parent = new Cascader.Item<String>("parent", "Parent", List.of(), true);
            var cascade = new Cascader<>(List.of(parent));
            ref.set(cascade);
            cascade.setChildrenProvider(item -> CompletableFuture.completedFuture(List.of(new Cascader.Item<>("child", "Child", List.of()))));
            cascade.getChildren().addListener((javafx.collections.ListChangeListener<javafx.scene.Node>) change -> {
                if (cascade.getChildren().size() == 2 && cascade.getChildren().getLast() instanceof javafx.scene.control.ComboBox) ready.countDown();
            });
            cascade.selectPath(List.of("parent"));
        });
        assertTrue(ready.await(5, TimeUnit.SECONDS));
        fx(() -> {
            ref.get().selectPath(List.of("parent", "child"));
            assertEquals(List.of("parent", "child"), ref.get().getValue());
        });
    }

    @Test void compositeSelectionsKeepOneValidatedWritePath() throws Exception {
        fx(() -> {
            var rate = new Rate(5);
            rate.setValue(4);
            assertThrows(IllegalArgumentException.class, () -> rate.setValue(6));
            assertEquals(4, rate.getValue());
            assertThrows(IllegalArgumentException.class, () -> rate.valueProperty().set(6));
            assertEquals(4, rate.getValue());
            var cascade = new Cascader<>(List.of(new Cascader.Item<>("a", "A", List.of())));
            cascade.selectPath(List.of("a"));
            assertEquals(List.of("a"), cascade.getValue());
            assertFalse(cascade.valueProperty() instanceof javafx.beans.value.WritableValue<?>);
            var root = new TreeItem<>("root");
            var child = new TreeItem<>("leaf");
            root.getChildren().add(child);
            var tree = new TreeSelect<>(root);
            tree.select(child);
            assertEquals("leaf", tree.getSelectedValue());
            assertFalse(tree.valueProperty() instanceof javafx.beans.value.WritableValue<?>);
        });
    }

    @Test void colorValueCannotBecomeNullThroughItsProperty() throws Exception {
        fx(() -> {
            var picker = new ColorPicker();
            var previous = picker.getValue();
            assertThrows(NullPointerException.class, () -> picker.valueProperty().set(null));
            assertEquals(previous, picker.getValue());
            assertEquals(previous, picker.getNativePicker().getValue());
        });
    }

    @Test void invalidBoundRatingDoesNotCorruptSelection() throws Exception {
        fx(() -> {
            var rate = new Rate(5);
            var source = new javafx.beans.property.SimpleIntegerProperty(4);
            rate.valueProperty().bind(source);
            assertEquals(4, rate.getValue());
            try { source.set(6); } catch (IllegalArgumentException invalid) {}
            assertEquals(4, rate.getValue());
            assertTrue(((javafx.scene.control.ToggleButton) rate.getChildren().get(3)).isSelected());
            assertFalse(((javafx.scene.control.ToggleButton) rate.getChildren().get(4)).isSelected());
            source.set(5);
            assertEquals(5, rate.getValue());
            rate.valueProperty().unbind();
            rate.setValue(3);
            assertEquals(3, rate.getValue());
            var nullable = new javafx.beans.property.SimpleObjectProperty<Number>(3);
            rate.valueProperty().bind(nullable);
            nullable.set(null);
            assertEquals(0, rate.getValue());
            rate.valueProperty().unbind();
        });
    }

    @Test void suggestionsAndMentionsFollowEditingState() throws Exception {
        fx(() -> {
            var auto = new AutoComplete();
            auto.setSuggestions(List.of("Alpha", "Beta", "Alpine"));
            auto.getEditor().setText("alp");
            assertEquals(List.of("Alpha", "Alpine"), List.copyOf(auto.getItems()));
            var mentions = new Mentions();
            mentions.setSuggestions(List.of("alice", "bob"));
            mentions.setText("Hello @al");
            mentions.positionCaret(mentions.getLength());
            mentions.insertMention("alice");
            assertEquals("Hello @alice ", mentions.getText());
        });
    }

    @Test void uploadIgnoresCancelledCompletionAndCanRetry() throws Exception {
        var completed = new CompletableFuture<Void>();
        var retry = new CompletableFuture<Void>();
        var finished = new CountDownLatch(1);
        var uploadRef = new AtomicReference<Upload>();
        fx(() -> {
            var upload = new Upload();
            uploadRef.set(upload);
            upload.setUploader(file -> completed);
            upload.addFiles(List.of(new File("photo.png")));
            var item = upload.getItems().getFirst();
            assertEquals(Upload.Status.UPLOADING, item.getStatus());
            upload.cancel(item);
            assertEquals(Upload.Status.CANCELLED, item.getStatus());
            upload.setUploader(file -> retry);
            item.statusProperty().addListener((observable, old, value) -> {
                if (value == Upload.Status.COMPLETE) finished.countDown();
            });
            upload.upload(item);
            assertEquals(Upload.Status.UPLOADING, item.getStatus());
            retry.complete(null);
        });
        assertTrue(finished.await(5, TimeUnit.SECONDS));
        fx(() -> {
            var upload = uploadRef.get();
            assertEquals(Upload.Status.COMPLETE, upload.getItems().getFirst().getStatus());
            upload.close();
        });
    }

    @Test void asyncSuggestionsRejectLateResponses() throws Exception {
        var first = new CompletableFuture<List<String>>();
        var second = new CompletableFuture<List<String>>();
        var ready = new CountDownLatch(1);
        var ref = new AtomicReference<AutoComplete>();
        fx(() -> {
            var auto = new AutoComplete();
            ref.set(auto);
            new Scene(new VBox(auto));
            auto.setProvider(query -> query.equals("a") ? first : second);
            auto.getSuggestions().addListener((javafx.collections.ListChangeListener<String>) change -> {
                if (auto.getSuggestions().equals(List.of("answer"))) ready.countDown();
            });
            auto.getEditor().setText("a");
            auto.getEditor().setText("an");
        });
        second.complete(List.of("answer"));
        assertTrue(ready.await(5, TimeUnit.SECONDS));
        first.complete(List.of("ancient"));
        fx(() -> assertEquals(List.of("answer"), List.copyOf(ref.get().getSuggestions())));
    }

    @Test void cancelledSuggestionRequestCancelsProviderFuture() throws Exception {
        var started = new CountDownLatch(1);
        var providerFuture = new CompletableFuture<List<String>>();
        var parent = new AtomicReference<VBox>();
        fx(() -> {
            var auto = new AutoComplete();
            var box = new VBox(auto);
            parent.set(box);
            new Scene(box);
            auto.setProvider(query -> { started.countDown(); return providerFuture; });
            auto.getEditor().setText("ask");
        });
        assertTrue(started.await(5, TimeUnit.SECONDS));
        fx(() -> parent.get().getChildren().clear());
        assertTrue(providerFuture.isCancelled());
    }

    @Test void cancelledCascaderRequestCancelsProviderFuture() throws Exception {
        var started = new CountDownLatch(1);
        var providerFuture = new CompletableFuture<List<Cascader.Item<String>>>();
        var control = new AtomicReference<Cascader<String>>();
        fx(() -> {
            var parent = new Cascader.Item<String>("parent", "Parent", List.of(), true);
            var cascade = new Cascader<>(List.of(parent));
            control.set(cascade);
            cascade.setChildrenProvider(item -> { started.countDown(); return providerFuture; });
            cascade.selectPath(List.of("parent"));
        });
        assertTrue(started.await(5, TimeUnit.SECONDS));
        fx(() -> control.get().selectPath(List.of()));
        assertTrue(providerFuture.isCancelled());
    }

    @Test void replacingCascaderProviderRestartsPendingBranch() throws Exception {
        var firstStarted = new CountDownLatch(1);
        var secondLoaded = new CountDownLatch(1);
        var first = new CompletableFuture<List<Cascader.Item<String>>>();
        var cascadeRef = new AtomicReference<Cascader<String>>();
        fx(() -> {
            var parent = new Cascader.Item<String>("parent", "Parent", List.of(), true);
            var cascade = new Cascader<>(List.of(parent));
            cascadeRef.set(cascade);
            cascade.setChildrenProvider(item -> { firstStarted.countDown(); return first; });
            cascade.selectPath(List.of("parent"));
        });
        assertTrue(firstStarted.await(5, TimeUnit.SECONDS));
        fx(() -> {
            var cascade = cascadeRef.get();
            cascade.setChildrenProvider(item -> CompletableFuture.completedFuture(List.of(new Cascader.Item<>("new", "New", List.of()))));
            cascade.getChildren().addListener((javafx.collections.ListChangeListener<javafx.scene.Node>) change -> {
                if (cascade.getChildren().size() == 2 && cascade.getChildren().getLast() instanceof javafx.scene.control.ComboBox) secondLoaded.countDown();
            });
        });
        assertTrue(first.isCancelled());
        assertTrue(secondLoaded.await(5, TimeUnit.SECONDS));
        fx(() -> {
            cascadeRef.get().selectPath(List.of("parent", "new"));
            assertEquals(List.of("parent", "new"), cascadeRef.get().getValue());
        });
    }

    @Test void treeInvokesLazyProviderOffFxThreadAndReportsFailure() throws Exception {
        var entered = new CountDownLatch(1);
        var errorShown = new CountDownLatch(1);
        var providerOnFx = new java.util.concurrent.atomic.AtomicBoolean(true);
        var treeRef = new AtomicReference<Tree<String>>();
        fx(() -> {
            var tree = new Tree<String>("root");
            treeRef.set(tree);
            new Scene(new VBox(tree));
            tree.loadErrorProperty().addListener((observable, old, failure) -> {
                if (failure != null) errorShown.countDown();
            });
            tree.setLazyChildren(value -> {
                providerOnFx.set(javafx.application.Platform.isFxApplicationThread());
                entered.countDown();
                throw new IllegalStateException("provider failed");
            });
        });
        assertTrue(entered.await(5, TimeUnit.SECONDS));
        assertFalse(providerOnFx.get());
        assertTrue(errorShown.await(5, TimeUnit.SECONDS));
        fx(() -> assertNotNull(treeRef.get().getLoadError()));
    }

    @Test void detachingTreeCancelsActualLazyFuture() throws Exception {
        var entered = new CountDownLatch(1);
        var future = new CompletableFuture<List<String>>();
        var holder = new AtomicReference<VBox>();
        fx(() -> {
            var tree = new Tree<String>("root");
            var box = new VBox(tree);
            holder.set(box);
            new Scene(box);
            tree.setLazyChildren(value -> { entered.countDown(); return future; });
        });
        assertTrue(entered.await(5, TimeUnit.SECONDS));
        fx(() -> holder.get().getChildren().clear());
        assertTrue(future.isCancelled());
    }

    @Test void detachingUploadCancelsActiveWorkAndAllowsRemount() throws Exception {
        var work = new CompletableFuture<Void>();
        fx(() -> {
            var upload = new Upload();
            upload.setUploader(file -> work);
            var parent = new VBox(upload);
            new Scene(parent);
            upload.addFiles(List.of(new File("one.txt")));
            parent.getChildren().clear();
            assertEquals(Upload.Status.CANCELLED, upload.getItems().getFirst().getStatus());
            parent.getChildren().add(upload);
            assertFalse(upload.getScene() == null);
            upload.close();
        });
    }

    @Test void cancellationReachesUploaderFutureAfterItHasStarted() throws Exception {
        var uploaderStarted = new CountDownLatch(1);
        var transfer = new CompletableFuture<Void>();
        var uploadRef = new AtomicReference<Upload>();
        fx(() -> {
            var upload = new Upload();
            uploadRef.set(upload);
            upload.setUploader(file -> {
                uploaderStarted.countDown();
                return transfer;
            });
            upload.addFiles(List.of(new File("later.txt")));
        });
        assertTrue(uploaderStarted.await(5, TimeUnit.SECONDS));
        fx(() -> {
            var upload = uploadRef.get();
            upload.cancel(upload.getItems().getFirst());
            assertEquals(Upload.Status.CANCELLED, upload.getItems().getFirst().getStatus());
            upload.close();
        });
        assertTrue(transfer.isCancelled());
    }

    @Test void ownedInputPopupsCloseWithAppAndInheritItsScene() throws Exception {
        fx(() -> {
            var multi = Select.multiple(javafx.collections.FXCollections.observableArrayList("A", "B"));
            var root = new App(multi);
            root.setThemeCss("-norm-canvas: #101010;");
            var stage = new Stage();
            stage.setScene(new Scene(root, 360, 260));
            stage.show();
            try {
                ((javafx.scene.control.Button) multi.getChildren().getFirst()).fire();
                assertTrue(multi.isShowing());
                root.close();
                assertFalse(multi.isShowing());
            } finally { root.close(); stage.close(); }
        });
    }
}
