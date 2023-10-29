package hedtek.graphing.intervalGraph;

public class Interval {

    private String name;
    private Integer start, end;

    public Interval(String name, Integer start, Integer end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(Interval other) {
        return false;
    }
}
