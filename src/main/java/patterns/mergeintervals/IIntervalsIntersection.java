package patterns.mergeintervals;

import java.util.*;

/**
 *
 *
 * Remember this is intersection and not merge
 * so we only need to cover what is intersected.
 *
 * Unable to solve this problem as well
 *
 *
 *
 * // Time complexity O(M + N )
 * // Space complexity O(1)
 */
class IIntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        int i = 0, j = 0;

        while( i < arr1.length && j < arr2.length) {

            if((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
                    || (arr2[i].start >= arr1[j].start && arr2[i].start <= arr1[j].end)){
                int newIntervalStart = Math.max(arr1[i].start,arr2[j].start);
                int newIntervalEnd = Math.min(arr1[i].end, arr2[j].end);
                intervalsIntersection.add(new Interval(newIntervalStart,newIntervalEnd));
            }

            if(arr1[i].end < arr2[j].end) {
                i++;
            }else {
                j++;
            }
        }

        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
//        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
//        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
//        Interval[] result = IIntervalsIntersection.merge(input1, input2);
//        System.out.print("Intervals Intersection: ");
//        for (Interval interval : result)
//            System.out.print("[" + interval.start + "," + interval.end + "] ");
//        System.out.println();

        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        Interval[] input2 = new Interval[] { new Interval(5, 10) };
        Interval[] result = IIntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}

