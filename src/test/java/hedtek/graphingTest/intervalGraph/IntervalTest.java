package hedtek.graphingTest.intervalGraph;
import hedtek.graphing.intervalGraph.Interval;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntervalTest {

    Interval a = new Interval("a", 1, 4);
    Interval b = new Interval("b", 1, 2);


    @Test
    void intervalsShouldIntersect () {
        Assertions.assertThat(a.overlaps(b)).isTrue();
    }

}
