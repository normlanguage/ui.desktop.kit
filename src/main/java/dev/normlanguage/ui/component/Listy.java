package dev.normlanguage.ui.component;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class Listy<T> extends List<T> implements AutoCloseable {
    private final java.util.List<RowCell> cells = new ArrayList<>();
    private java.util.List<RowCell> mounted = java.util.List.of();
    private java.util.List<T> published = java.util.List.of();
    private java.util.List<Node> rendered = java.util.List.of();
    private Consumer<java.util.List<T>> rows;
    private boolean queued;
    private boolean closed;

    public Listy() {
        getStyleClass().add("norm-listy");
        setFixedCellSize(32);
        setCellFactory(unused -> {
            var cell = new RowCell();
            cells.add(cell);
            return cell;
        });
    }

    public void setRowHeight(double height) {
        if (!Double.isFinite(height) || height <= 0) throw new IllegalArgumentException("row height");
        setFixedCellSize(height);
    }

    public void rows(Consumer<java.util.List<T>> listener) {
        if (closed) throw new IllegalStateException("list is closed");
        boolean attach = rows == null;
        rows = listener;
        if (attach && listener != null) listener.accept(published);
        schedule();
    }

    public void rowNodes(java.util.List<Node> nodes) {
        if (closed) return;
        if (nodes.size() != mounted.size()) throw new IllegalArgumentException("visible row count");
        rendered = java.util.List.copyOf(nodes);
        for (var cell : cells) cell.setGraphic(null);
        for (int index = 0; index < mounted.size(); index++) {
            mounted.get(index).setText(null);
            mounted.get(index).setGraphic(nodes.get(index));
        }
    }

    private void schedule() {
        if (closed || queued) return;
        queued = true;
        Platform.runLater(() -> {
            queued = false;
            if (closed) return;
            var next = cells.stream().filter(cell -> cell.getScene() != null && !cell.isEmpty() && cell.getIndex() >= 0 && cell.getIndex() < getItems().size())
                .sorted(Comparator.comparingInt(RowCell::getIndex)).toList();
            var items = next.stream().map(RowCell::getItem).toList();
            boolean changed = !items.equals(published);
            mounted = next;
            published = items;
            if (changed && rows != null) rows.accept(items);
            else if (rows != null && rendered.size() == mounted.size()) rowNodes(rendered);
        });
    }

    @Override public void close() {
        if (closed) return;
        closed = true;
        rows = null;
        for (var cell : cells) { cell.setGraphic(null); cell.setText(null); }
        cells.clear();
        mounted = java.util.List.of();
        published = java.util.List.of();
        rendered = java.util.List.of();
        setCellFactory(null);
    }

    private final class RowCell extends ListCell<T> {
        @Override protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            setGraphic(null);
            setText(empty || rows != null ? null : String.valueOf(item));
            schedule();
        }
        @Override public void updateIndex(int index) {
            super.updateIndex(index);
            schedule();
        }
    }
}
