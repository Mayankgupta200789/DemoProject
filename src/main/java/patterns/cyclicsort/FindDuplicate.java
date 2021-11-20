package patterns.cyclicsort;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {

        int i = 0;

        while( i < nums.length ) {

            int j = nums[i] - 1;

            if( nums[i] != nums[j]) {
                swap(nums,i,j);
            } else {
                i++;
            }
        }

        i = 0;

        while( i < nums.length ) {

            if( nums[i] != (i + 1)) {
                return nums[i];
            }
            i++;
        }

        return -1;

    }

    public void swap(int[] nums,int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
