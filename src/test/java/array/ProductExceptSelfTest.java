package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

 The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 You must write an algorithm that runs in O(n) time and without using the division operation.

 Example 1:

 Input: nums = [1,2,3,4]
 Output: [24,12,8,6]
 Example 2:

 Input: nums = [-1,1,0,-3,3]
 Output: [0,0,9,0,0]
 *
 */

public class ProductExceptSelfTest {

    private ProductExceptSelf productExceptSelf;

    @Before
    public void setUp() throws Exception {

        productExceptSelf = new ProductExceptSelf();
    }

    @Test
    public void productExceptSelf() {

        int[] nums = new int[]{-1,-2,-4};
        int[] output = new int[]{8,4,2};
        // -1 -2
        //  1 -1
        // rightProductTrack = -2
        // -2 -1

        //rightproducttrack = -8
        int[] result = productExceptSelf.productExceptSelf(nums);

        Assert.assertArrayEquals(output,result);


    }
}