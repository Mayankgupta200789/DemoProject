package patterns.slidingwindow;

public class MinSubArray {

    public static int findMinSubArray(int S, int[] arr) {

       int minSubArray = Integer.MAX_VALUE;

       int windowStart= 0;
       int windowSum = 0 ;

       for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

           windowSum += arr[windowEnd];

           while(windowSum >= S ){

               minSubArray = Math.min(minSubArray,(windowEnd - windowStart) + 1);
               windowSum -= arr[windowStart];
               windowStart++;
           }
       }

       return minSubArray != Integer.MAX_VALUE ? minSubArray : 0;
    }
}
