package dev.normlanguage.ui.component;

import java.util.Objects;

public record TableSortState(String columnId, boolean descending) {
    public TableSortState { Objects.requireNonNull(columnId); }
}
