package patterns.slidingwindow;

import array.MaximumSubarray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumSubArrayOfSizeKTest {

    private MaxSumSubArrayOfSizeK maxSumSubArrayOfSizeK;

    @Test
    public void findMaxSumSubArray() {
        int maxSumSubArray1 = MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2});
        int maxSumSubArray2 = MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5});
        int maxSumSubArray3 = MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 3, 4, 1, 5});
        int maxSumSubArray4 = MaxSumSubArrayOfSizeK.findMaxSumSubArray(4, new int[]{2, -3, 4, -1, 5});
        int maxSumSubArray5 = MaxSumSubArrayOfSizeK.findMaxSumSubArray(0, new int[]{2, -3, 4, -1, 5});
        int maxSumSubArray6 = MaxSumSubArrayOfSizeK.findMaxSumSubArray(1, new int[]{2, -3, 4, -1, 5});
        int maxSumSubArray7 = MaxSumSubArrayOfSizeK.findMaxSumSubArray(10, new int[]{2, -3, 4, -1, 5});

        Assert.assertEquals(9,maxSumSubArray1);
        Assert.assertEquals(7,maxSumSubArray2);
        Assert.assertEquals(10,maxSumSubArray3);
        Assert.assertEquals(5,maxSumSubArray4);
        Assert.assertEquals(0,maxSumSubArray5);
        Assert.assertEquals(5,maxSumSubArray6);
        Assert.assertEquals(0,maxSumSubArray7);
    }
}