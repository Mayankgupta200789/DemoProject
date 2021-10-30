package patterns.slidingwindow;

public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {

        if(arr.length == 0 || k == 0 || k > arr.length ) return 0;
        int windowStart = 0 ;
        int windowEnd = k - 1;
        int windowSum = 0;

        int maxSum = Integer.MIN_VALUE;


        for(int i = 0 ; i <= windowEnd; i++ ) {

            windowSum += arr[i];
        }

        maxSum = Math.max(maxSum,windowSum);

        while(windowEnd < arr.length - 1) {

            windowSum -= arr[windowStart];
            windowStart++;
            windowEnd++;
            windowSum += arr[windowEnd];
            maxSum = Math.max(maxSum,windowSum);
        }

        return maxSum;
    }
}
