package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarrayTest {

    private MaximumSubarray maximumSubarray;

    @Before
    public void setUp() throws Exception {

        maximumSubarray = new MaximumSubarray();
    }

    @Test
    public void sum1() {

        int[] nums = new int[]{ -2,1,-3,4,-1,2,1,-5,4,-9,-4,5,-2,-2,1,2,3};

        int sum = maximumSubarray.sum(nums);

        Assert.assertEquals(7,sum);


    }

    @Test
    public void sum2() {

        int[] nums = new int[]{ 1};

        int sum = maximumSubarray.sum(nums);

        Assert.assertEquals(1,sum);


    }

    @Test
    public void sum3() {

        int[] nums = new int[]{ 5,4,-1,7,8};

        int sum = maximumSubarray.sum(nums);

        Assert.assertEquals(23,sum);


    }


    // FAILED LEETCODE CASE FOR ME.
    @Test
    public void sum5() {

        int[] nums = new int[]{ -1,-2};

        int sum = maximumSubarray.sum(nums);

        Assert.assertEquals(-1,sum);
    }
}