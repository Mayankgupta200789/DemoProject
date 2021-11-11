package patterns.mergeintervals;


//https://leetcode.com/problems/merge-intervals/submissions/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time complexity O(N log N)
// Space complexity for sorting O(N)
// Collections.sort() uses either merge sort or timsort
public class IMergedIntervals {

    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0],b[0]));

        if(intervals.length < 2 ) {
            return intervals;
        }

        List<List<Integer>> merged = new ArrayList<>();

        int previousStart = intervals[0][0];
        int previousEnd = intervals[0][1];

        for(int i = 1; i < intervals.length;i++ ) {

            if(previousEnd >= intervals[i][0]) {
                previousEnd = Math.max(intervals[i][1],previousEnd);
            } else {
                List<Integer> output = Arrays.asList(previousStart,previousEnd);
                previousStart = intervals[i][0];
                previousEnd  = intervals[i][1];
                merged.add(output);
            }
        }

        merged.add(Arrays.asList(previousStart,previousEnd));

        int[][] result = new int[merged.size()][2];
        int a = 0;


        for(List<Integer> values : merged) {

            result[a][0] = values.get(0);
            result[a++][1] = values.get(1);
        }

        return result;
    }
}
