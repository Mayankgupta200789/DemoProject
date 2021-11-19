package patterns.cyclicsort;

// Logic for cyclic sort is to keep on
// swapping unless we get correct result at that inde
// if the number is missing then, we know that
// we need to keep the same element at that index
// and don't swap if element index is higher that max length of array.
public class IMissingNumberFinder {

    public int missingNumber(int[] nums) {
        int i = 0;
        //[8, 3, 5, 2, 4, 6, 0, 1]
        while( i < nums.length ) {

            int j = nums[i];
            if(j < nums.length && nums[i] != nums[j]) {
                swap(nums,i,j);
            }  else {
                i++;
            }
        }
        i = 0;

        while( i < nums.length ) {
            if( nums[i] != i ) {
                return i;
            }
            i++;
        }
        return nums.length;
    }

    void swap(int[] nums, int i , int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
