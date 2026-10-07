package dev.normlanguage.ui.component;

public final class Progress extends javafx.scene.control.ProgressBar {
    public Progress() { super(-1); }
    public Progress(double progress) { this(); setFraction(progress); }

    public void setFraction(double fraction) {
        if (!Double.isFinite(fraction) || fraction < 0 || fraction > 1)
            throw new IllegalArgumentException("fraction must be between zero and one");
        setProgress(fraction);
    }

    public void setWork(int completed, int total) {
        if (total <= 0 || completed < 0 || completed > total)
            throw new IllegalArgumentException("work must satisfy zero <= completed <= positive total");
        setProgress((double) completed / total);
    }
}
