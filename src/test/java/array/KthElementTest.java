package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KthElementTest {

    private KthElement kthElement;

    @Before
    public void setUp() throws Exception {

        kthElement = new KthElement();
    }

    @Test
    public void findKthLargest() {

        int[] nums = new int[] {1,10,11,12,14,9};

//        1,9,10,11,12,14
        int result = kthElement.findKthLargest(nums, 3);

        Assert.assertEquals(result,11);

        int[] nums2 = new int[] {3,2,3,1,2,4,5,5,6};

        //3,2,3,1,2,4,5,5,6

        int result2 = kthElement.findKthLargest(nums2, 4);

        Assert.assertEquals(result2,4);

        int[] nums3 = new int[] {3,2,1,5,6,4};
        //1,2,3,4,5,6

       int result3 = kthElement.findKthLargest(nums3, 2);

        Assert.assertEquals(result3,5);

    }
}