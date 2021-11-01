package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fruit-into-baskets/

public class FruitsIntoBasket {

    public int totalFruit(int[] fruits) {

        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> fruitMap = new HashMap<Integer,Integer>();

        int windowStart = 0 ;

        for(int windowEnd = 0 ; windowEnd < fruits.length; windowEnd++ ) {

            fruitMap.put(fruits[windowEnd],fruitMap.getOrDefault(fruits[windowEnd],0) + 1);

            while(fruitMap.size() > 2 ) {

                fruitMap.put(fruits[windowStart],fruitMap.get(fruits[windowStart]) - 1);

                if(fruitMap.get(fruits[windowStart]) == 0 ) {

                    fruitMap.remove(fruits[windowStart]);
                }

                windowStart++;
            }
            max = Math.max(max,windowEnd - windowStart + 1);
        }

        return max != Integer.MIN_VALUE ? max : fruits.length;

    }
}
