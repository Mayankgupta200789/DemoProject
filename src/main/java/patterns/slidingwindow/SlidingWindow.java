package patterns.slidingwindow;

public class SlidingWindow {

    public double[] slide(int[] input ,int k ) {

        double[] result = new double[input.length - k + 1];

        int windowStart = 0;
        int windowEnd = k - 1;
        int sum = 0;

        for(int i = 0 ; i < k; i++ ) {

            sum = sum + input[i];
        }

        int j = 0;
        if(result.length > 0 ) result[j++] = sum /k;

        while(windowEnd < input.length - 1 ) {

            sum = sum - input[windowStart];
            windowStart++;
            windowEnd++;
            sum = sum + input[windowEnd];
            result[j++] = sum /k;
        }

        return result;
    }
}
