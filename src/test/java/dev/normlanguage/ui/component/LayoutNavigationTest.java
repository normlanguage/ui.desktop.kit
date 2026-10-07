package dev.normlanguage.ui.component;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class LayoutNavigationTest extends FxTest {
    @Test void splitterAndFloatingActionsOwnTheirNativeContent() throws Exception {
        fx(() -> {
            var split = new Splitter(new Label("left"), new Label("right"));
            assertEquals(2, split.getItems().size());
            assertNotNull(new Divider());
            var floatLayer = new StackPane();
            var floatButton = new FloatButton("+").attachTo(floatLayer);
            assertSame(floatLayer, floatButton.getParent());
            assertThrows(IllegalStateException.class, () -> floatButton.attachTo(floatLayer));
            var floatGroup = new FloatButton.Group(new FloatButton("A"), new FloatButton("B")).attachTo(floatLayer);
            assertEquals(2, floatGroup.getChildren().size());
        });
    }

    @Test void anchorScrollsToNativeTarget() throws Exception {
        fx(() -> {
            var first = new Label("first");
            var last = new Label("last");
            var content = new VBox(first, last);
            first.setMinHeight(200);
            last.setMinHeight(200);
            var pane = new ScrollPane(content);
            var anchor = new Anchor(pane);
            var lastItem = new Anchor.Item("Last", last);
            anchor.getItems().addAll(new Anchor.Item("First", first), lastItem);
            var stage = new Stage();
            stage.setScene(new Scene(new VBox(anchor, pane), 300, 150));
            stage.show();
            try {
                anchor.scrollTo(lastItem);
                assertSame(lastItem, anchor.getActiveItem());
                assertTrue(pane.getVvalue() > 0);
                pane.setVvalue(0);
                assertEquals("First", anchor.getActiveItem().text());
            } finally { stage.close(); }
        });
    }

    @Test void typographyEditsTextWithNativeEditor() throws Exception {
        fx(() -> {
            var text = new Typography("Draft");
            text.setEditable(true);
            text.beginEdit();
            assertTrue(text.isEditing());
            var editor = (javafx.scene.control.TextField) text.getGraphic();
            editor.setText("Final");
            text.commitEdit();
            assertEquals("Final", text.getText());
            assertFalse(text.isEditing());
            text.beginEdit();
            ((javafx.scene.control.TextField) text.getGraphic()).setText("Canceled");
            text.cancelEdit();
            assertEquals("Final", text.getText());
        });
    }

    @Test void navigationAndFeedbackAreInteractive() throws Exception {
        fx(() -> {
            var changes = new AtomicInteger();
            var pagination = new Pagination(41, 10);
            pagination.currentPageProperty().addListener((observable, old, value) -> changes.incrementAndGet());
            pagination.next();
            assertEquals(2, pagination.getCurrentPage());
            pagination.last();
            assertEquals(5, pagination.getCurrentPage());
            pagination.next();
            assertEquals(2, changes.get());
            var steps = new Steps("Start", "Finish");
            steps.setCurrentStep(1);
            assertEquals(1, steps.getCurrentStep());
            var breadcrumb = new Breadcrumb();
            breadcrumb.getItems().add(new Breadcrumb.Item("Home", changes::incrementAndGet));
            assertEquals(1, breadcrumb.getItems().size());
            var tabs = new Tabs();
            tabs.add("One", new Label("content"));
            assertEquals(1, tabs.getTabs().size());
            var menu = new Menu();
            menu.add("File", new javafx.scene.control.MenuItem("Open"));
            assertEquals(1, menu.getMenus().size());
        });
    }

    @Test void dropdownUsesOwnedScopedPopup() throws Exception {
        fx(() -> {
            var dropdown = new Dropdown("Open", new Label("options"));
            var app = new App(dropdown);
            var stage = new Stage();
            stage.setScene(new Scene(app, 300, 200));
            stage.show();
            try {
                dropdown.show();
                assertTrue(dropdown.isShowing());
                app.close();
                assertFalse(dropdown.isShowing());
            } finally { app.close(); stage.close(); }
        });
    }
}
