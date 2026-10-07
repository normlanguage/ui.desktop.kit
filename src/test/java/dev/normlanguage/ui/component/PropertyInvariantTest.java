package dev.normlanguage.ui.component;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.time.YearMonth;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInvariantTest extends FxTest {
    @Test void directPropertyWritesPreserveNavigationRanges() throws Exception {
        fx(() -> {
            var carousel = new Carousel(List.of(new Label("one"), new Label("two")));
            assertThrows(IndexOutOfBoundsException.class, () -> carousel.indexProperty().set(-1));
            assertThrows(IndexOutOfBoundsException.class, () -> carousel.indexProperty().set(2));
            assertEquals(0, carousel.getIndex());
            carousel.close();

            var pagination = new Pagination(21, 10);
            assertThrows(IllegalArgumentException.class, () -> pagination.pageSizeProperty().set(0));
            assertThrows(IllegalArgumentException.class, () -> pagination.totalItemsProperty().set(-1));
            assertEquals(10, pagination.getPageSize());
            assertEquals(21, pagination.getTotalItems());
            pagination.currentPageProperty().set(99);
            assertEquals(3, pagination.getCurrentPage());

            var steps = new Steps("Start", "Finish");
            assertThrows(IndexOutOfBoundsException.class, () -> steps.currentStepProperty().set(-1));
            assertEquals(0, steps.getCurrentStep());
            steps.setCurrentStep(1);
            steps.getSteps().removeLast();
            assertEquals(0, steps.getCurrentStep());

            var anchor = new Anchor(new ScrollPane());
            assertThrows(NullPointerException.class, () -> anchor.scrollPaneProperty().set(null));
            assertNotNull(anchor.getScrollPane());
        });
    }

    @Test void calendarAndStatisticFollowLiveScopedLocale() throws Exception {
        fx(() -> {
            var calendar = new Calendar();
            calendar.setDisplayedMonth(YearMonth.of(2026, 7));
            assertThrows(NullPointerException.class, () -> calendar.displayedMonthProperty().set(null));
            assertEquals(YearMonth.of(2026, 7), calendar.getDisplayedMonth());
            var statistic = new Statistic("Count", 1234.5);
            assertThrows(NullPointerException.class, () -> statistic.valueProperty().set(null));
            var app = new App(new VBox(calendar, statistic));
            var base = ComponentConfig.defaults();
            app.setConfig(new ComponentConfig(base.fontFamily(), base.fontSize(), base.density(),
                    base.radius(), base.motionEnabled(), Locale.FRANCE));
            assertEquals("juillet 2026", ((Label) ((HBox) calendar.getTop()).getChildren().get(1)).getText());
            assertEquals("lun.", ((Label) ((javafx.scene.layout.GridPane) calendar.getCenter()).getChildren().getFirst()).getText());
            assertEquals(NumberFormat.getNumberInstance(Locale.FRANCE).format(1234.5),
                    ((Label) statistic.getChildren().get(1)).getText());
            app.setConfig(new ComponentConfig(base.fontFamily(), base.fontSize(), base.density(),
                    base.radius(), base.motionEnabled(), Locale.US));
            assertEquals("Sun", ((Label) ((javafx.scene.layout.GridPane) calendar.getCenter()).getChildren().getFirst()).getText());
            assertEquals(NumberFormat.getNumberInstance(Locale.US).format(1234.5),
                    ((Label) statistic.getChildren().get(1)).getText());
            app.close();
            calendar.close();
            statistic.close();
        });
    }
}
