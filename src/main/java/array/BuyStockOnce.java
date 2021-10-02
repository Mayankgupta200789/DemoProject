package array;

/**
 *
 *
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

 You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

 Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 TRICK IS TO KEEP TRACK OF MIN AND MAX PROFIT.
 */

public class BuyStockOnce {

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0 ) return 0;

        int min = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length ; i++ ) {

            if(prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }

            if(prices[i] < min ) {
                min = prices[i];
            }

        }
        return maxProfit;

    }
}
