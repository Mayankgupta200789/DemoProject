package companies.doordash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxProfitPerWorker {

    public static void main(String[] args) {

        int[] difficulty = new int[]{7,20,68};
        int[] profit = new int[]{26,28,57};
        int[] worker = new int[]{71,20,71};
        new MaxProfitPerWorker().maxProfitAssignment(difficulty, profit,worker);
    }


    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Map<Integer,Integer> hashMap = new HashMap<>();
        int maxProfit = 0;

        int i = 0;

        while( i < difficulty.length ) {

            hashMap.put(difficulty[i],profit[i]);
            i++;
        }
        Arrays.sort(difficulty);
        Arrays.sort(worker);
        Map<Integer,Integer> maxProfitPerWorker = new HashMap<>();
        int k = 0;
        int result = 0;
        i = 0;
        while(i < difficulty.length && k < worker.length) {

            if(worker[k] >= difficulty[i]) {
                result = maxProfitPerWorker.getOrDefault(worker[k],0);
                result = Math.max(result,hashMap.get(difficulty[i]));
                maxProfitPerWorker.put(worker[k],result);
                i++;
            } else {
                maxProfitPerWorker.put(worker[k],result);
                k++;
            }

        }

        for(Map.Entry<Integer,Integer> entry : maxProfitPerWorker.entrySet()) {

            maxProfit += entry.getValue();
        }



        return maxProfit;


    }
}
