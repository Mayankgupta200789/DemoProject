package patterns.slidingwindow;

public class SlidingWindow {

    public static double[] findAverages(int K, int[] arr) {

        double[] result = new double[arr.length - K + 1];
        int windowStart = 0,windowSum = 0;
        for(int windowEnd = 0 ; windowEnd < arr.length; windowEnd++ ){

            windowSum += arr[windowEnd];

            if(windowEnd >= K - 1) {

                result[windowStart] = windowSum/K;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }

}
