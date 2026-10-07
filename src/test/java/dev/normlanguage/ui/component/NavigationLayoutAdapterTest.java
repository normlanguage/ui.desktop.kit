package dev.normlanguage.ui.component;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class NavigationLayoutAdapterTest extends FxTest {
    @Test void tabsKeepPagesNonClosableAcrossProjectionUpdates() throws Exception {
        fx(() -> {
            var tabs = new Tabs();
            assertEquals(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE, tabs.getTabClosingPolicy());
            NavigationLayoutAdapter.tabs(tabs, List.of("First"), List.of(new Label("first")));
            assertEquals(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE, tabs.getTabClosingPolicy());
        });
    }



    @Test void tabsReuseNativeTabsAcrossReorderingAndSelectionIsTwoWay() throws Exception {
        fx(() -> {
            var tabs = new Tabs();
            var first = new Label("first");
            var second = new Label("second");
            NavigationLayoutAdapter.tabs(tabs, List.of("First", "Second"), List.of(first, second));
            var original = tabs.getTabs().getFirst();
            var link = NavigationLayoutAdapter.tabsSelection(tabs);
            var changes = new AtomicInteger();
            link.update(1, ignored -> changes.incrementAndGet());
            assertEquals(1, tabs.getSelectionModel().getSelectedIndex());
            NavigationLayoutAdapter.tabs(tabs, List.of("Second", "First"), List.of(second, first));
            assertSame(original, tabs.getTabs().get(1));
            tabs.getSelectionModel().select(0);
            assertEquals(1, changes.get());
            link.close();
            tabs.getSelectionModel().select(1);
            assertEquals(1, changes.get());
        });
    }

    @Test void anchorHostTracksScrollAndUpdatesTargets() throws Exception {
        fx(() -> {
            var host = NavigationLayoutAdapter.anchorHost();
            var first = new Label("first");
            var second = new Label("second");
            first.setMinHeight(300);
            second.setMinHeight(300);
            NavigationLayoutAdapter.anchor(host, List.of("First", "Second"), List.of(first, second));
            var stage = new Stage();
            stage.setScene(new Scene(new VBox(host), 360, 180));
            stage.show();
            try {
                var oldChanges = new AtomicInteger();
                var selection = NavigationLayoutAdapter.anchorSelection(host);
                selection.update(0, ignored -> oldChanges.incrementAndGet());
                selection.unbind();
                host.anchor().scrollTo(host.anchor().getItems().get(1));
                assertTrue(host.scrollPane().getVvalue() > 0);
                assertSame(second, host.anchor().getActiveItem().target());
                assertEquals(0, oldChanges.get());
                NavigationLayoutAdapter.anchor(host, List.of("Second", "First"), List.of(second, first));
                assertSame(second, host.anchor().getItems().getFirst().target());
                assertSame(host.anchor().getItems().getFirst(), host.anchor().getActiveItem());
                selection.close();
            } finally {
                stage.close();
                host.close();
            }
        });
    }

    @Test void navigationActionsAndPopupContentUpdateWithoutReplacingOwners() throws Exception {
        fx(() -> {
            var breadcrumbs = new Breadcrumb();
            var invoked = new AtomicInteger(-1);
            NavigationLayoutAdapter.breadcrumb(breadcrumbs, List.of("Home", "Detail"), invoked::set);
            ((javafx.scene.control.Hyperlink) breadcrumbs.getChildren().getLast()).fire();
            assertEquals(1, invoked.get());

            var menu = new Menu();
            NavigationLayoutAdapter.menuGroup(menu, "File", List.of("Open", "Save"), invoked::set);
            menu.getMenus().getFirst().getItems().getFirst().fire();
            assertEquals(0, invoked.get());

            var dropdown = NavigationLayoutAdapter.dropdown("Options");
            var first = new Label("first");
            var second = new Label("second");
            NavigationLayoutAdapter.dropdownContent(dropdown, first);
            NavigationLayoutAdapter.dropdownContent(dropdown, second);
            assertSame(second, dropdown.content().getChildren().getFirst());
            dropdown.close();

            var floating = NavigationLayoutAdapter.floatButton("+");
            NavigationLayoutAdapter.floatButtonContent(floating, new Label("page"));
            assertEquals(2, floating.node().getChildren().size());
            floating.close();
            floating.close();

            var primary = new Button("Go");
            NavigationLayoutAdapter.buttonAction(primary, () -> invoked.set(7));
            primary.fire();
            assertEquals(7, invoked.get());
        });
    }

    @Test void layoutProjectionReusesChildrenAndPreservesOrder() throws Exception {
        fx(() -> {
            var first = new Label("first");
            var second = new Label("second");
            var splitter = NavigationLayoutAdapter.splitter();
            NavigationLayoutAdapter.splitter(splitter, List.of(first, second), 0.4);
            assertEquals(2, splitter.getItems().size());
        });
    }
}
