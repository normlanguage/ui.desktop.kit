package dev.normlanguage.ui.component;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.StackPane;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.function.Function;

public final class DisplayAdapter {
    private DisplayAdapter() {}

    public static Badge badge() { return new Badge(new StackPane()); }
    public static Card card(String title) { return new Card(title, new StackPane()); }
    public static Collapse collapse(String title) { return new Collapse(title, new StackPane()); }
    public static Statistic statistic(String title, int value) { return new Statistic(title, value); }
    public static void statisticValue(Statistic control, int value) { control.setValue(value); }
    public static void tagOnClose(Tag control, Runnable action) {
        control.setOnClose(action);
    }

    public static void avatarSource(Avatar control, String source) {
        if (java.util.Objects.equals(control.getProperties().get("norm-avatar-source"), source)) return;
        control.getProperties().put("norm-avatar-source", source);
        control.setImage(source == null || source.isBlank() ? null : new javafx.scene.image.Image(source, true));
    }

    public static void badgeContent(Badge control, Node content) {
        control.getChildren().set(0, content);
    }

    public static void cardContent(Card control, Node content) {
        control.setCenter(content);
    }

    public static void cardSlots(Card control, Node content, Node bottom) {
        control.setCenter(content);
        control.setBottom(bottom);
    }

    public static void collapseContent(Collapse control, Node content) {
        control.setContent(content);
    }

    public static void carouselSlides(Carousel control, java.util.List<Node> slides) {
        if (!control.getSlides().equals(slides)) control.getSlides().setAll(slides);
    }

    public static void descriptions(Descriptions control, java.util.List<String> labels, java.util.List<Node> values) {
        if (labels.size() != values.size()) throw new IllegalArgumentException("labels and values differ");
        control.clearItems();
        for (int index = 0; index < labels.size(); index++) control.add(labels.get(index), values.get(index));
    }

    public static void timeline(Timeline control, java.util.List<String> times, java.util.List<Node> values) {
        if (times.size() != values.size()) throw new IllegalArgumentException("times and values differ");
        control.getChildren().clear();
        for (int index = 0; index < times.size(); index++) control.add(times.get(index), values.get(index));
    }

    public static <T> void items(ListView<T> control, java.util.List<T> values) {
        var selected = control.getSelectionModel().getSelectedItem();
        if (!control.getItems().equals(values)) control.getItems().setAll(values);
        if (selected != null && values.contains(selected)) control.getSelectionModel().select(selected);
    }

    public static <T> void segmentedItems(Segmented<T> control, java.util.List<T> values) {
        if (!control.getItems().equals(values)) control.getItems().setAll(values);
    }

    public static <T> void rows(Table<T> control, java.util.List<T> values) {
        var selected = control.getSelectionModel().getSelectedItem();
        if (control.getSource() == null) control.setSource(javafx.collections.FXCollections.observableArrayList(values));
        else if (!control.getSource().equals(values)) control.getSource().setAll(values);
        if (selected != null && values.contains(selected)) control.getSelectionModel().select(selected);
    }

    public static <T> TableColumn<T,String> column(Table<T> control, String heading, Function<T,String> value) {
        return control.column(heading, value);
    }

    public static <T> void tableColumns(Table<T> control, java.util.List<TableColumnSpec<T>> specifications) {
        var ids = new java.util.HashSet<String>();
        for (var specification : specifications)
            if (!ids.add(specification.id())) throw new IllegalArgumentException("Duplicate column id: " + specification.id());
        var previous = new java.util.HashMap<String,TableColumn<T,?>>();
        for (var column : control.getColumns()) previous.put(column.getId(), column);
        var next = new java.util.ArrayList<TableColumn<T,?>>();
        for (var specification : specifications) {
            @SuppressWarnings("unchecked")
            var column = (TableColumn<T,T>) previous.get(specification.id());
            if (column == null) column = new TableColumn<>();
            column.setId(specification.id());
            column.setText(specification.heading());
            column.setCellValueFactory(cell -> new javafx.beans.property.ReadOnlyObjectWrapper<>(cell.getValue()));
            column.setSortable(specification.comparator() != null);
            if (specification.comparator() != null) column.setComparator(specification.comparator());
            column.setCellFactory(ignored -> specification.widget() ? control.widgetCell(specification.id()) : new javafx.scene.control.TableCell<>() {
                @Override protected void updateItem(T row, boolean empty) {
                    super.updateItem(row, empty);
                    setText(empty || row == null ? null : specification.display().apply(row));
                    setGraphic(null);
                }
            });
            next.add(column);
        }
        var order = new java.util.ArrayList<>(control.getSortOrder());
        order.removeIf(column -> !next.contains(column) || !column.isSortable());
        if (!control.getColumns().equals(next)) control.getColumns().setAll(next);
        control.getSortOrder().setAll(order);
        control.sort();
        control.refresh();
    }

    public static <T> void treeChildren(Tree<T> control, Function<T,java.util.List<T>> children) {
        var value = control.getRoot().getValue();
        var updated = treeItem(value, children, new java.util.HashSet<>());
        if (sameTree(control.getRoot(), updated)) return;
        control.setLazyChildren(null);
        control.setRoot(updated);
        control.getRoot().setExpanded(true);
    }

    private static <T> boolean sameTree(TreeItem<T> left, TreeItem<T> right) {
        if (!java.util.Objects.equals(left.getValue(), right.getValue())
                || left.getChildren().size() != right.getChildren().size()) return false;
        for (int index = 0; index < left.getChildren().size(); index++)
            if (!sameTree(left.getChildren().get(index), right.getChildren().get(index))) return false;
        return true;
    }

    private static <T> TreeItem<T> treeItem(T value, Function<T,java.util.List<T>> children, java.util.Set<T> ancestors) {
        if (!ancestors.add(value)) throw new IllegalArgumentException("tree contains a cycle");
        var item = new CheckBoxTreeItem<>(value);
        for (var child : children.apply(value)) item.getChildren().add(treeItem(child, children, ancestors));
        ancestors.remove(value);
        return item;
    }

    public static ValueLink<LocalDate> calendarValue(Calendar control) {
        return new ValueLink<>(control, control.valueProperty());
    }

    public static ValueLink<YearMonth> calendarMonth(Calendar control) {
        return new ValueLink<>(control, control.displayedMonthProperty());
    }

    public static ValueLink<Boolean> collapseExpanded(Collapse control) {
        return new ValueLink<>(control, control.expandedProperty());
    }

    public static <T> SelectionLink<T> selected(ListView<T> control) {
        var selection = control.getSelectionModel();
        return new SelectionLink<>(control, selection.selectedItemProperty(), value -> {
            if (value == null) selection.clearSelection(); else selection.select(value);
        });
    }

    public static <T> SelectionLink<T> tableSelected(Table<T> control) {
        var selection = control.getSelectionModel();
        return new SelectionLink<>(control, selection.selectedItemProperty(), value -> {
            if (value == null) selection.clearSelection(); else selection.select(value);
        });
    }

    public static <T> ValueLink<T> segmentedValue(Segmented<T> control) {
        return new ValueLink<>(control, control.valueProperty());
    }

    public static <T> TreeSelectionLink<T> treeSelected(Tree<T> control) {
        return new TreeSelectionLink<>(control);
    }

}
