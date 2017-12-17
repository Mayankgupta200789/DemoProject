package array;

/**
 * @Author Mayank Gupta
 * @Date 11/1/17
 */
public class MaximumSumArray {

    public static void main(String args[]) {

        MaximumSumArray maximumSumArray = new MaximumSumArray();
        maximumSumArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});

    }

    public int maxSubArray(int[] nums) {

        int max_so_far = nums[0];
        int max_over_all = nums[0];
        int startIndex_so_far = 0;
        int endIndex_so_far = 0;
        int startIndex_over_all = 0;
        int endIndex_over_all = 0;


        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > max_so_far + nums[i]) {
                startIndex_so_far = i;
                endIndex_so_far = i;

            } else {
                endIndex_so_far = i;
            }


            max_so_far = Math.max(nums[i], nums[i] + max_so_far);


            if (max_so_far > max_over_all) {
                startIndex_over_all = startIndex_so_far;
                endIndex_over_all = endIndex_so_far;
            }


            max_over_all = Math.max(max_over_all, max_so_far);
        }

        System.out.println("Start index  is " + startIndex_over_all);
        System.out.println("End index  is " + endIndex_over_all);
        System.out.println("Max sum is " + max_over_all);

        return max_over_all;
    }
}
