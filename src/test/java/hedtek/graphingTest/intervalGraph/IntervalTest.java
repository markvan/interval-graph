package hedtek.graphingTest.intervalGraph;
import hedtek.graphing.intervalGraph.Interval;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class IntervalTest {

    @Test
    void intervalsShouldOverlap () {
        Interval interval_2_6 = new Interval("a", 2, 6);
        Interval interval_1_3 = new Interval("b", 1, 3);
        Interval interval_3_5 = new Interval("c", 3, 5);
        SoftAssertions assertions = new SoftAssertions();
        // part overlaps
        assertions.assertThat( interval_2_6.overlaps( interval_1_3 )).isTrue();
        assertions.assertThat( interval_1_3.overlaps( interval_2_6 )).isTrue();
        // full overlaps
        assertions.assertThat( interval_2_6.overlaps( interval_3_5 )).isTrue();
        assertions.assertThat( interval_3_5.overlaps( interval_2_6 )).isTrue();
        assertions.assertAll();
    }

    @Test
    void intervalsShouldNotOverlap () {
        Interval interval_1_4 = new Interval("a", 1, 4);
        Interval interval_4_6 = new Interval("b", 4, 6);
        Interval interval_8_10 = new Interval( "c", 8, 10);
        SoftAssertions assertions = new SoftAssertions();
        // no overlap but start and end points are the same
        assertions.assertThat( interval_1_4.overlaps( interval_4_6 )).isFalse();
        assertions.assertThat( interval_4_6.overlaps( interval_1_4 )).isFalse();
        // no overlap, gaps between start and end points
        assertions.assertThat( interval_4_6.overlaps( interval_8_10 )).isFalse();
        assertions.assertThat( interval_8_10.overlaps( interval_4_6 )).isFalse();
        assertions.assertAll();
    }

    @Test
    void canNotCreateAnUnnamedInterval() {
        Throwable thrown = catchThrowable(() -> {
            new Interval("",3,4);
        });
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Attempt to create an unnamed interval");
    }

    @Test
    void canNotCreateAnIntervalWithSameStartAndEnd () {
        Throwable thrown = catchThrowable(() -> { new Interval("a",3,3); });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Attempt to create Interval with start >= end");
    }

    @Test
    void canNotCreateAnIntervalWithStartAfterEnd () {
        Throwable thrown = catchThrowable(() -> { new Interval("a",3,2); });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Attempt to create Interval with start >= end");
    }

}
