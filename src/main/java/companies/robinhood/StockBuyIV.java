package companies.robinhood;

import java.util.Arrays;

public class StockBuyIV {

    /**
     * Extending solution to at most k transactions
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        if(k == 0 ) return 0;

        int[] dpCost = new int[k];
        Arrays.fill(dpCost,Integer.MAX_VALUE);
        int[] dpProfit = new int[k];

        for(int price : prices) {

            //dpCost[0]  = Math.min(dpCost[0],price);
            //dpProfit[0] = Math.max(dpProfit[0],price - dpCost[0]);

            //dpCost[1] = Math.min(dpCost[1],price - dpProfit[0]);
            //doProfit[1] = Math.min(dpProfit[1], price - dpCost[1]);

            int profit = 0;
            for(int i = 0 ; i < k ; i++ ) {

                dpCost[i] = Math.min(dpCost[i],price - profit);
                dpProfit[i] = Math.max(dpProfit[i],price - dpCost[i]);

                // Every time last transaction happens, that will be reduced from new price
                // because you have earned that profit.
                profit = dpProfit[i];
            }


        }

        return dpProfit[k - 1];
    }
}
