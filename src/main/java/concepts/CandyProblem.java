package concepts;

import java.util.Arrays;

/**
 * @Author Mayank Gupta
 * @Date 8/15/17
 */
public class CandyProblem {

    public int candy(int[] ratings) {

        int n;
        int i;

        if (ratings == null)
            return 0;

        n = ratings.length;

        if (n == 0)
            return 0;

        int candiesL[] = new int[n];
        int candiesR[] = new int[n];
        Arrays.fill(candiesL, 1);
        Arrays.fill(candiesR, 1);

        for (i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candiesL[i] = candiesL[i - 1] + 1;
            }
        }

        for (i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candiesR[i] = candiesR[i + 1] + 1;
        }

        int res = 0;

        for (i = 0; i < n; i++) {
            res += Math.max(candiesL[i], candiesR[i]);
        }

        return res;

    }
}
