package dev.normlanguage.ui.component;

import java.util.Objects;

public record TableCellSlot<T>(String columnId, int index, T row) {
    public TableCellSlot { Objects.requireNonNull(columnId); Objects.requireNonNull(row); }
}
