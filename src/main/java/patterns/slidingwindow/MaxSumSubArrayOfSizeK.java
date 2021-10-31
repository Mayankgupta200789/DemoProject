package patterns.slidingwindow;

public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {

        int maxSum = Integer.MIN_VALUE;

        int windowStart = 0;
        int windowSum =0 ;

        for(int windowEnd = 0 ; windowEnd < arr.length ; windowEnd++ ) {

            windowSum += arr[windowEnd];

            if(windowEnd >= k - 1) {

                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }

}
