package dev.normlanguage.ui.component;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

public record TableColumnSpec<T>(String id, String heading, Function<T,String> display, Comparator<T> comparator, boolean widget) {
    public TableColumnSpec {
        if (Objects.requireNonNull(id).isBlank()) throw new IllegalArgumentException("Column id is blank");
        Objects.requireNonNull(heading);
        Objects.requireNonNull(display);
    }
}
