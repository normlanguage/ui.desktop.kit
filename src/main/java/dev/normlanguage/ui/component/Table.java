package dev.normlanguage.ui.component;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Node;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiConsumer;
public class Table<T> extends TableView<T> implements AutoCloseable {
    private ObservableList<T> source;
    private FilteredList<T> filtered;
    private SortedList<T> sorted;
    private final java.util.Set<WidgetCell> cells = java.util.Collections.newSetFromMap(new java.util.WeakHashMap<>());
    private java.util.List<WidgetCell> visibleCells = java.util.List.of();
    private java.util.List<TableCellSlot<T>> visibleSlots = java.util.List.of();
    private java.util.List<Node> mountedNodes = java.util.List.of();
    private java.util.function.Consumer<java.util.List<TableCellSlot<T>>> visibleChanged;
    private boolean queued;
    private boolean closed;

    public void cellSlots(java.util.function.Consumer<java.util.List<TableCellSlot<T>>> changed) {
        visibleChanged = changed;
        requestSlots();
    }

    public void cellNodes(java.util.List<Node> nodes) {
        if (nodes.size() != visibleCells.size()) throw new IllegalArgumentException("Cell nodes and slots differ");
        mountedNodes = java.util.List.copyOf(nodes);
        for (int index = 0; index < nodes.size(); index++) visibleCells.get(index).setGraphic(nodes.get(index));
    }

    public javafx.scene.control.TableCell<T,T> widgetCell(String columnId) { return new WidgetCell(columnId); }

    private void requestSlots() {
        if (queued || closed) return;
        queued = true;
        javafx.application.Platform.runLater(() -> {
            queued = false;
            if (closed) return;
            var nextCells = cells.stream().filter(cell -> !cell.isEmpty() && cell.getItem() != null && cell.getIndex() >= 0
                    && cell.getScene() != null && getColumns().contains(cell.getTableColumn()))
                    .sorted(java.util.Comparator.comparingInt((WidgetCell cell) -> cell.getIndex()).thenComparing(cell -> cell.columnId)).toList();
            var nextSlots = nextCells.stream().map(cell -> new TableCellSlot<>(cell.columnId, cell.getIndex(), cell.getItem())).toList();
            boolean changed = !nextSlots.equals(visibleSlots);
            if (!changed && mountedNodes.size() == nextCells.size()) {
                for (var cell : visibleCells) cell.setGraphic(null);
                for (int index = 0; index < nextCells.size(); index++) nextCells.get(index).setGraphic(mountedNodes.get(index));
            }
            visibleCells = nextCells;
            visibleSlots = nextSlots;
            if (changed && visibleChanged != null) visibleChanged.accept(nextSlots);
        });
    }

    private final class WidgetCell extends javafx.scene.control.TableCell<T,T> {
        private final String columnId;
        private WidgetCell(String columnId) {
            this.columnId = columnId;
            cells.add(this);
            sceneProperty().addListener((observable, previous, next) -> requestSlots());
        }
        @Override protected void updateItem(T row, boolean empty) {
            super.updateItem(row, empty);
            setText(null);
            setGraphic(null);
            requestSlots();
        }
        @Override public void updateIndex(int index) { super.updateIndex(index); requestSlots(); }
    }

    @Override public void close() {
        if (closed) return;
        closed = true;
        visibleChanged = null;
        for (var cell : cells) cell.setGraphic(null);
        cells.clear();
        visibleCells = java.util.List.of();
        visibleSlots = java.util.List.of();
        mountedNodes = java.util.List.of();
        if (sorted != null) sorted.comparatorProperty().unbind();
        getColumns().clear();
        setItems(javafx.collections.FXCollections.observableArrayList());
        source = null;
        filtered = null;
        sorted = null;
    }

    public Table() { getStyleClass().add("norm-table"); }
    public void setSource(ObservableList<T> rows) {
        if (sorted != null) sorted.comparatorProperty().unbind();
        source = java.util.Objects.requireNonNull(rows);
        filtered = new FilteredList<>(rows);
        sorted = new SortedList<>(filtered);
        sorted.comparatorProperty().bind(comparatorProperty());
        setItems(sorted);
    }
    public ObservableList<T> getSource() { return source; }
    public void setPredicate(Predicate<T> predicate) {
        if (filtered == null) throw new IllegalStateException("Set source before filter");
        filtered.setPredicate(predicate);
    }
    public <V> TableColumn<T,V> observableColumn(String heading, Function<T,ObservableValue<V>> value) {
        var column = new TableColumn<T,V>(heading);
        column.setCellValueFactory(cell -> value.apply(cell.getValue()));
        getColumns().add(column);
        return column;
    }
    public TableColumn<T,String> editableColumn(String heading, Function<T,ObservableValue<String>> value, BiConsumer<T,String> commit) {
        var column = observableColumn(heading, value);
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setEditable(true);
        setEditable(true);
        column.setOnEditCommit(event -> commit.accept(event.getRowValue(), event.getNewValue()));
        return column;
    }
    public <V> TableColumn<T,V> column(String heading, Function<T,V> value) {
        var column = new TableColumn<T,V>(heading);
        column.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(value.apply(cell.getValue())));
        getColumns().add(column);
        return column;
    }
}
