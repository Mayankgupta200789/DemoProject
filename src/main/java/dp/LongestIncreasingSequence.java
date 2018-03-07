package dp;

import java.util.Arrays;

public class LongestIncreasingSequence {



    public int getLongestIncreasingSequence(int[] inputs) {

        int n = inputs.length;
        int[] dp = new int[n+1];

        Arrays.fill(dp,1);
        int max = 0;

        for(int i = 1; i < inputs.length; i++ ) {

            for(int j = 0; j <= i; j++ ) {

                if( inputs[j] > inputs[i] && dp[i] < (dp[j] + 1)) {
                    dp[i] += 1;
                    max = max > dp[i] ? max : dp[i];
                }
            }
        }


        return max;

    }
}
