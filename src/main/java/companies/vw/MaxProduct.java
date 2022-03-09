package companies.vw;

public class MaxProduct {

    /***
     * This solution is very tricky solution
     * The idea is max product should be including
     * either 0 or last index from the end or both
     * Now when a zero comes into the picture.
     * It should not be included in the product.
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int left = 0,right = 0, result = nums[0];

        // 0 0 0

        for(int i = 0 ; i < nums.length; i++ ) {

            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right ) * nums[nums.length - i - 1];

            result = Math.max(result,Math.max(left,right));

        }


        return result;


    }
}
