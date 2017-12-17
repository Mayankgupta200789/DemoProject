package concepts;

/**
 * @Author Mayank Gupta
 * @Date 1/4/17
 */
public class RotatedSortedArray {


    public static void main(String args[]) {


        int[] nums = new int[]{6,7,8,1,2,3};

        RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
        System.out.println(rotatedSortedArray.search(nums,5));

    }

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        if( nums.length == 0 ) return -1;

        if( nums.length == 1 && target == nums[0]) {
            return 0;
        } else if( nums.length == 1) {
            return -1;
        }


        while( low <= high ) {

            int mid = (low + high )/2;

            if( target == nums[mid] ) {
                return mid;
            }

            if( nums[low] < nums[mid] ) {

                if( target > nums[low] && target < nums[mid] ) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if( nums[high] > nums[mid] ) {

                if( target > nums[mid] && target < nums[high] ) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return -1;

    }
}
