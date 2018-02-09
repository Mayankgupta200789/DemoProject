package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Mayank Gupta
 * @Date 10/7/17
 */
public class TargetDiff {

    public static void main(String[] args) {

        TargetDiff targetDiff = new TargetDiff();

        int[] nums = {1,2,3,4,5};
        int result = targetDiff.findPairs(nums, -1);


        // a - b = k
        //a = k + b
        System.out.println("Resultant pairs total is  " +result);
    }

    private int findPairs(int[] nums, int k) {

        int result = 0;

        if(nums == null || nums.length == 0 ) {
            return result;
        }

        Set<Integer> hashSet = new HashSet<>();
        Set<Pair> hashPairs = new HashSet<>();


        for (int num : nums) {

            int output1 = k + num;
//            int output2 = nums[i] - k;

            if (hashSet.contains(output1) && !hashPairs.contains(new Pair(num, output1))) {
                result++;
                hashPairs.add(new Pair(num, output1));
            }

//            if ( hashSet.contains(output2) && !hashPairs.contains(new Pair(nums[i], output2)) ) {
//                result++;
//                hashPairs.add(new Pair(nums[i],output2));
//            }

            hashSet.add(num);

        }

        return result;

    }

    class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o ) {
            if (this == o ) return true;
            if( this.getClass() != o.getClass() ) return false;

            Pair pair = (Pair)o;

            if( this.x == pair.y && this.y == pair.x ) return true;

            if( this.x == pair.x && this.y == pair.y ) return true;

            return false;
        }

        @Override
        public int hashCode() {

            int result1 = 0;
            result1 = 31  + x;
            result1 = 31 * result1 + y;

            int result2 = 0;
            result2 = 31  + y;
            result2 = 31 * result2 + x;
            return result1 + result2;
        }


    }
}
