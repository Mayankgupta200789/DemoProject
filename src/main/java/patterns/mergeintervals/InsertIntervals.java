package patterns.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Time complexity - O(N)
// Space complexity - O(N) for collections. sort algorithm

public class InsertIntervals {

        public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> mergedIntervals = new ArrayList<>();

            int i = 0;
            int previousEnd = newInterval.end;
            int previousStart = newInterval.start;

            while(i < intervals.size() && intervals.get(i).end < newInterval.start ) {
                mergedIntervals.add(intervals.get(i++));
            }

            while(i < intervals.size() && newInterval.end >= intervals.get(i).start ){
                previousEnd = Math.max(intervals.get(i).end, newInterval.end);
                previousStart = Math.min(intervals.get(i).start,newInterval.start);
                i++;
            }

            mergedIntervals.add(new Interval(previousStart,previousEnd));

            while(i < intervals.size()) {
                mergedIntervals.add(intervals.get(i++));
            }
            return mergedIntervals;
        }

        public static void main(String[] args) {
            List<Interval> input = new ArrayList<Interval>();
            input.add(new Interval(1, 3));
            input.add(new Interval(5, 7));
            input.add(new Interval(8, 12));
            System.out.print("Intervals after inserting the new interval: ");
            for (Interval interval : InsertIntervals.insert(input, new Interval(4, 6)))
                System.out.print("[" + interval.start + "," + interval.end + "] ");
            System.out.println();

            input = new ArrayList<Interval>();
            input.add(new Interval(1, 3));
            input.add(new Interval(5, 7));
            input.add(new Interval(8, 12));
            System.out.print("Intervals after inserting the new interval: ");
            for (Interval interval : InsertIntervals.insert(input, new Interval(4, 10)))
                System.out.print("[" + interval.start + "," + interval.end + "] ");
            System.out.println();

            input = new ArrayList<Interval>();
            input.add(new Interval(2, 3));
            input.add(new Interval(5, 7));
            System.out.print("Intervals after inserting the new interval: ");
            for (Interval interval : InsertIntervals.insert(input, new Interval(1, 4)))
                System.out.print("[" + interval.start + "," + interval.end + "] ");
            System.out.println();
       }
}
