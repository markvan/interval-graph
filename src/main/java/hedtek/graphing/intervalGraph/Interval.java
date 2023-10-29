package hedtek.graphing.intervalGraph;

public class Interval {

    private String name;
    private Integer start, end;

    public Interval(String name, Integer start, Integer end) throws IllegalArgumentException {
        if (name.length() == 0 )
            throw new IllegalArgumentException("Attempt to create an unnamed interval");
        if (start >= end)
            throw new IllegalArgumentException("Attempt to create Interval with start >= end");

        this.name = name;
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(Interval other) {
        if (this.end<=other.start || this.start>=other.end ) return false;
        return true;
    }
}
