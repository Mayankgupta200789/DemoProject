package companies.robinhood;


/**
 * It really took me hours to completely understand this. The comment really helps me. Now I share my understanding.
 *
 * var maxProfit = function(prices) {
 *   let oneBuyOneSell = 0;
 *   let twoBuyTwoSell = 0;
 *   let oneBuy = Number.POSITIVE_INFINITY
 *   let twoBuy = Number.POSITIVE_INFINITY;
 *
 *   for(let i = 0; i < prices.length; i++) {
 *     const p = prices[i];
 *     oneBuy = Math.min(oneBuy, p);
 *     oneBuyOneSell = Math.max(oneBuyOneSell, p - oneBuy);
 *     twoBuy = Math.min(twoBuy, p - oneBuyOneSell);
 *     twoBuyTwoSell = Math.max(twoBuyTwoSell, p - twoBuy);
 *   }
 *
 *   return twoBuyTwoSell;
 * };
 * Similar to Buy and Sell Stock I, where only one transaction allowed, we keep track the lowest price and once the price exceeds the old lowest price, we record the difference.
 *
 * var maxProfit = function(prices) {
 *   const size = prices.length;
 *   let lowPrice = prices[0];
 *   let profit = 0;
 *
 *   for(let i = 1; i < size; i++) {
 *     if(prices[i] < lowPrice) {
 *       lowPrice = prices[i];
 *     } else {
 *       profit = Math.max(prices[i] - lowPrice, profit);
 *     }
 *   }
 *
 *   return profit;
 * };
 * Here, the oneBuy keeps track of the lowest price, and oneBuyOneSell keeps track of the biggest profit we could get.
 * Then the tricky part comes, how to handle the twoBuy? Suppose in real life, you have bought and sold a stock and
 * made $100 dollar profit. When you want to purchase a stock which costs you $300 dollars, how would you think this?
 * You must think, um, I have made $100 profit, so I think this $300 dollar stock is worth $200 FOR ME since I have hold $100 for free.
 * There we go, you got the idea how we calculate twoBuy!! We just minimize the cost again!! The twoBuyTwoSell is just making as much profit as possible.
 * Hope this explanation helps other people to understand this!
 *
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * This is for at most two transactions
 */
public class StockBuyIII {

    public static void main(String[] args) {

        new StockBuyIII().maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }

    public int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE,
                t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0,
                t2Profit = 0;

        int[] dpCost = new int[prices.length];
        int[] dpProfit = new int[prices.length];

        for (int price : prices) {
            // the maximum profit if only one transaction is allowed
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            // Because we have gained profit from this transaction
            // Thus, next stock prices will be the difference of current price and profit
            // Explanation is present in above comments
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }

        return t2Profit;
    }
}
