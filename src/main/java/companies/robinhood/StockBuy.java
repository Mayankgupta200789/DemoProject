package companies.robinhood;

public class StockBuy {

    public static void main(String[] args) {

        new StockBuy().maxProfit(new int[]{1,20,5,3,6,4});
    }

    public int maxProfit(int[] prices) {

        int buy, profit = 0;

        int i =0 ;

        while( i < prices.length){

            while(i < (prices.length - 1) && prices[i+1] <= prices[i]) i++;

            buy = prices[i];

            while(i < (prices.length - 1) && prices[i+1] > prices[i]) i++;

            if(i < prices.length) profit += prices[i] - buy;
            i++;
        }

        return profit;
    }


}
