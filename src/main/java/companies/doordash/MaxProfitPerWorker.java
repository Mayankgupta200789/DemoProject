package companies.doordash;

import java.util.*;

public class MaxProfitPerWorker {

    public class Work {


         int difficulty;
         int profit;

         public Work(int difficulty, int profit ) {
             this.difficulty = difficulty;
             this.profit = profit;
         }

    }

    public static void main(String[] args) {

        int[] difficulty = new int[]{68,35,52,47,86};
        int[] profit = new int[]{67,17,1,81,3};
        int[] worker = new int[]{92,10,85,84,82};

        new MaxProfitPerWorker().maxProfitAssignment(difficulty, profit,worker);
    }


    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        List<Work> workList = new ArrayList<>();

        for(int i = 0 ; i < difficulty.length; i++ ) {

            workList.add(new Work(difficulty[i],profit[i]));

        }

        int result = 0;
        int best = 0;

        workList.sort(Comparator.comparingInt(a -> a.difficulty));

        Arrays.sort(worker);
        int k = 0;


        for(int ability : worker ) {

            while( k < profit.length && ability >= workList.get(k).difficulty)
                best = Math.max(best, workList.get(k++).profit);

            result += best;
        }

        return result;






    }
}
