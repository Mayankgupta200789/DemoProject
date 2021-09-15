package array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


//Given an integer array nums and an integer k, return the kth largest element in the array.

//Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Few important concepts to learn here

// 1) Priority Queue size cannot be controlled.
// 2) By default it maintains ascending order and it will k order.
// 3) If you want to maintain k sorted elements please check if size becomes k + 1, then remove element from queue.
// 4) Time complexity for this algorithm is n O(logk)
// 5) Space complexity for this algorithm is O(k)
// 6) QUEUE TREATS DUPLICATES DIFFERENTLY.

public class KthElement {

    public int findKthLargest(int[] nums, int k) {

        if(k >= nums.length) return 0;

        //[3,2,3,1,2,4,5,5,6]
        //1,2,2,3,3,4,5,5,6
        Queue<Integer> queue = new PriorityQueue<>(k);

        for( int i = 0; i < nums.length ; i++ ) {

            queue.add(nums[i]);

            if(queue.size() == (k + 1) ) queue.remove();
        }

        return queue.peek();
    }

    public int findKthSmallest(int[] nums, int k) {

        if(k >= nums.length) return 0;

        //[3,2,3,1,2,4,5,5,6]
        //1,2,2,3,3,4,5,5,6

        Queue<Integer> queue = new PriorityQueue<>();

        int maintainSizeDiffK = nums.length - k;

        for( int i = 0; i < nums.length ; i++ ) {

            queue.add(nums[i]);

            if(queue.size() > maintainSizeDiffK) queue.remove();
        }

        return queue.peek();
    }


}
