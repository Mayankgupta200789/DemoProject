package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> duplicateNumbers = new ArrayList<>();

        int i =0 ;

        while( i < nums.length ) {

            int j = nums[i] - 1;
            if( nums[i] != nums[j]) {
                swap(nums,i,j);
            } else {
                i++;
            }
        }

        i =0 ;

        while( i < nums.length ) {
            if(nums[i] != (i + 1)) {
                duplicateNumbers.add(nums[i]);
            }
            i++;
        }
        // TODO: Write your code here
        return duplicateNumbers;

    }

    public void swap(int[] nums,int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
