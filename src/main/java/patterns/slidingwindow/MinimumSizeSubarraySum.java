package patterns.slidingwindow;


//https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {

        int windowSum = 0;
        int windowStart = 0;
        int min = Integer.MAX_VALUE;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++ ) {

            windowSum += nums[windowEnd];

            while(windowSum >= target) {
                min = Math.min(min, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }

        }

        return min != Integer.MAX_VALUE ? min : 0;

    }
}
