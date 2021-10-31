package patterns.slidingwindow;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinSubArrayTest {



    @Test
    public void findMinSubArray() {

        int arr1[] = new int[]{2,1,5,2,3,1};
        int arr2[] = new int[]{2, 1, 5, 2, 8};
        int arr3[] = new int[]{3, 4, 1, 1, 6};

        Assert.assertEquals(2,MinSubArray.findMinSubArray(7, arr1));
        Assert.assertEquals(1,MinSubArray.findMinSubArray(7, arr2));
        Assert.assertEquals(3,MinSubArray.findMinSubArray(8, arr3));

    }
}