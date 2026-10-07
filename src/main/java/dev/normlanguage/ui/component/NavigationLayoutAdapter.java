package dev.normlanguage.ui.component;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class NavigationLayoutAdapter {
    private NavigationLayoutAdapter() {}

    public static Splitter splitter() { return new Splitter(); }
    public static Steps createSteps() { return new Steps(); }

    public static void buttonAction(Button control, Runnable action) {
        Util.requireFxThread();
        control.setOnAction(event -> action.run());
    }

    public static void splitter(Splitter control, List<Node> nodes, double dividerPosition) {
        Util.requireFxThread();
        control.getItems().setAll(nodes);
        if (nodes.size() > 1) control.setDividerPosition(0, dividerPosition);
    }

    public static void clearMenu(Menu control) {
        Util.requireFxThread();
        control.getMenus().clear();
    }

    public static AnchorHost anchorHost() { return new AnchorHost(); }

    public static void anchor(AnchorHost host, List<String> titles, List<Node> sections) {
        Util.requireFxThread();
        if (titles.size() != sections.size()) throw new IllegalArgumentException("Anchor titles and sections must be paired");
        var active = host.anchor.getActiveItem();
        host.content.getChildren().setAll(sections);
        var entries = new ArrayList<Anchor.Item>();
        for (int index = 0; index < titles.size(); index++) entries.add(new Anchor.Item(titles.get(index), sections.get(index)));
        host.anchor.getItems().setAll(entries);
        if (active != null) {
            for (var entry : entries) {
                if (entry.target() == active.target()) {
                    host.anchor.activeItemProperty().set(entry);
                    break;
                }
            }
        }
        if (entries.isEmpty()) host.activeIndex.set(-1);
        else if (host.activeIndex.get() >= entries.size()) host.activeIndex.set(entries.size() - 1);
    }

    public static IndexLink anchorSelection(AnchorHost host) {
        Util.requireFxThread();
        return new IndexLink(host, host.activeIndex, host::select);
    }

    public static final class AnchorHost extends HBox implements AutoCloseable {
        private final VBox content = new VBox(16);
        private final ScrollPane scrollPane = new ScrollPane(content);
        private final Anchor anchor = new Anchor(scrollPane);
        private final IntegerProperty activeIndex = new SimpleIntegerProperty(this, "activeIndex", -1);
        private final ChangeListener<Anchor.Item> activeChanged = (observable, previous, current) ->
                activeIndex.set(anchor.getItems().indexOf(current));

        private AnchorHost() {
            getStyleClass().add("norm-anchor-host");
            getChildren().addAll(anchor, scrollPane);
            HBox.setHgrow(scrollPane, javafx.scene.layout.Priority.ALWAYS);
            scrollPane.setFitToWidth(true);
            anchor.activeItemProperty().addListener(activeChanged);
        }
        public Anchor anchor() { return anchor; }
        public ScrollPane scrollPane() { return scrollPane; }
        private void select(int index) {
            if (index < 0 || index >= anchor.getItems().size()) return;
            var item = anchor.getItems().get(index);
            if (item.target().getScene() != null) anchor.scrollTo(item);
            else anchor.activeItemProperty().set(item);
        }
        @Override public void close() {
            anchor.activeItemProperty().removeListener(activeChanged);
            anchor.close();
        }
    }

    public static void breadcrumb(Breadcrumb control, List<String> titles, Consumer<Integer> action) {
        Util.requireFxThread();
        var entries = new ArrayList<Breadcrumb.Item>();
        for (int index = 0; index < titles.size(); index++) {
            int selected = index;
            entries.add(new Breadcrumb.Item(titles.get(index), () -> action.accept(selected)));
        }
        control.getItems().setAll(entries);
    }

    public static void menuGroup(Menu control, String title, List<String> labels, Consumer<Integer> action) {
        Util.requireFxThread();
        var group = new javafx.scene.control.Menu(title);
        for (int index = 0; index < labels.size(); index++) {
            var item = new MenuItem(labels.get(index));
            int selected = index;
            item.setOnAction(event -> action.accept(selected));
            group.getItems().add(item);
        }
        control.getMenus().add(group);
    }

    public static DropdownHost dropdown(String title) { return new DropdownHost(title); }

    public static FloatButtonHost floatButton(String title) { return new FloatButtonHost(title); }

    public static void floatButtonContent(FloatButtonHost host, Node content) {
        Util.requireFxThread();
        host.layer.getChildren().removeIf(node -> node != host.button);
        host.layer.getChildren().addFirst(content);
    }

    public static final class FloatButtonHost implements AutoCloseable {
        private final StackPane layer = new StackPane();
        private final FloatButton button;

        private FloatButtonHost(String title) { button = new FloatButton(title).attachTo(layer); }
        public StackPane node() { return layer; }
        public void title(String title) { button.setText(title); }
        public void action(Runnable action) { button.setOnAction(event -> action.run()); }
        @Override public void close() { button.close(); }
    }

    public static void dropdownContent(DropdownHost host, Node content) {
        Util.requireFxThread();
        host.content.getChildren().setAll(content);
    }

    public static final class DropdownHost implements AutoCloseable {
        private final StackPane content = new StackPane();
        private final Dropdown control;

        private DropdownHost(String title) { control = new Dropdown(title, content); }
        public Node node() { return control; }
        public StackPane content() { return content; }
        public void title(String title) { control.setText(title); }
        @Override public void close() { control.close(); }
    }

    public static void tabs(Tabs control, List<String> titles, List<Node> pages) {
        Util.requireFxThread();
        if (titles.size() != pages.size()) throw new IllegalArgumentException("Tab titles and pages must be paired");
        var existing = new IdentityHashMap<Node, Tab>();
        for (var tab : control.getTabs()) if (tab.getContent() != null) existing.put(tab.getContent(), tab);
        var ordered = new ArrayList<Tab>();
        for (int index = 0; index < pages.size(); index++) {
            var page = pages.get(index);
            var tab = existing.get(page);
            if (tab == null) tab = new Tab();
            tab.setText(titles.get(index));
            tab.setContent(page);
            ordered.add(tab);
        }
        control.getTabs().setAll(ordered);
    }

    public static IndexLink tabsSelection(Tabs tabs) {
        Util.requireFxThread();
        return new IndexLink(tabs, tabs.getSelectionModel().selectedIndexProperty(), index -> tabs.getSelectionModel().select(index));
    }

    public static IndexLink paginationSelection(Pagination control) {
        Util.requireFxThread();
        return new IndexLink(control, control.currentPageProperty(), control::setCurrentPage);
    }

    public static IndexLink stepsSelection(Steps control) {
        Util.requireFxThread();
        return new IndexLink(control, control.currentStepProperty(), control::setCurrentStep);
    }

    public static void steps(Steps control, List<String> titles) {
        Util.requireFxThread();
        control.getSteps().setAll(titles);
    }

    public static final class IndexLink implements AutoCloseable {
        private final SelectionLink<Number> link;

        private IndexLink(Node node, ObservableValue<Number> selected, IntConsumer select) {
            link = new SelectionLink<>(node, selected, value -> select.accept(value.intValue()));
        }
        public void update(int index, Consumer<Integer> changed) {
            link.update(index, value -> changed.accept(value.intValue()));
        }
        public void unbind() { link.unbind(); }
        @Override public void close() { link.close(); }
    }
}
