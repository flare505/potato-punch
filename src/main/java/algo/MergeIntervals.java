package algo;

import java.util.*;

public class MergeIntervals {
    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void printMergedIntervals(List<Interval> intervals) {
        // sort intervals by start then end
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                else {
                    return o1.end - o2.end;
                }
            }
        });

        intervals.forEach(interval -> {
            System.out.println(interval.start + " " + interval.end);
        });
        System.out.println("=========");

        List<Interval> ans = new ArrayList<>();
        int low = intervals.get(0).start;
        int high = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++) {
            Interval currInterval = intervals.get(i);
            if (currInterval.start <= high) {
                high = Math.max(currInterval.end, high);
            } else {
                ans.add(new Interval(low, high));
                low = currInterval.start;
                high = currInterval.end;
                if (i == intervals.size() - 1) {
                    ans.add(new Interval(low, high));
                }
            }
        }

        ans.forEach(interval -> {
            System.out.println(interval.start + " " + interval.end);
        });
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(2, 3),
                new Interval(3, 5),
                new Interval(6, 7),
                new Interval(5, 9),
                new Interval(11, 13)
        );

        printMergedIntervals(intervals);
    }
}
