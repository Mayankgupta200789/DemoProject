package array;


// Median is middle element for sorted array.
public class MedianWithoutSorting {

    public int findMedian(int[] nums) {

        int median;
        int mid1;
        int mid2;

        KthElement kthElement = new KthElement();

        if(nums.length % 2 == 0 ) {
            mid1 = kthElement.findKthSmallest(nums,(nums.length - 1)/2);
            mid2 = kthElement.findKthSmallest(nums,(nums.length)/2);
            median = mid1 + mid2 / 2;
        } else {
            median = kthElement.findKthSmallest(nums,nums.length/2);

        }

        return median;
    }
}
