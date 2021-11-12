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

// Time complexity - O(nlogn)
// Space complexity - O(N) for collections. sort algorithm

public class InsertIntervals {

        public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> mergedIntervals = new ArrayList<>();

            intervals.add(newInterval);

            Collections.sort(intervals,(a, b) -> Integer.compare(a.start,b.start));

            if(intervals.size() < 2) return intervals;

            int previousStart = intervals.get(0).start;
            int previousEnd = intervals.get(0).end;


            for(int i = 1; i < intervals.size(); i++ ) {

                Interval currentInterval = intervals.get(i);

                if(previousEnd >= currentInterval.start ) {
                    previousEnd = Math.max(currentInterval.end,previousEnd);
                }else {

                    mergedIntervals.add(new Interval(previousStart,previousEnd));
                    previousStart = currentInterval.start;
                    previousEnd = currentInterval.end;
                }
            }
            mergedIntervals.add(new Interval(previousStart,previousEnd));
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
