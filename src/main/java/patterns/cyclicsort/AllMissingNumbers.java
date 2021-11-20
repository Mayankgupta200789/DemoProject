package patterns.cyclicsort;

import java.util.*;
class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        // TODO: Write your code here

        int i = 0;

        while( i < nums.length ) {

            int j = nums[i] - 1;
            if( nums[i] != nums[j]){
                swap(nums,i,j);
            }else {
                i++;
            }
        }
        i = 0;
        while( i < nums.length ) {
            if( nums[i] != i + 1 ) {
                missingNumbers.add(i + 1);
            }
            i++;
        }
        return missingNumbers;
    }

    public static void swap(int[] nums,int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
