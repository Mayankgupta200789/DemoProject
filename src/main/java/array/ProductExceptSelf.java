package array;

/**
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

 The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 You must write an algorithm that runs in O(n) time and without using the division operation.
 https://leetcode.com/problems/product-of-array-except-self/
 */

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        if(nums == null ) return null;
        if(nums.length == 1 )return nums;

        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i = 1; i < nums.length; i++ ) {

            output[i] = nums[i-1]*output[i-1];

        }

        int rightProductTrack = 1;

        for(int j = output.length - 2; j >= 0; j-- ) {

            rightProductTrack *= nums[j+1];
            output[j] = output[j]*rightProductTrack;
        }

        return output;
    }
}
