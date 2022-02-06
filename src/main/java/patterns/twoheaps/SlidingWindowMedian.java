package patterns.twoheaps;

import java.util.*;


/**
 *
 * Time complexity #
 * The time complexity of our algorithm is O(N*K) where
 * ‘N’ is the total number of elements in the input array and
 * ‘K’ is the size of the sliding window. This is due to the fact
 * that we are going through all the ‘N’ numbers and, while doing so,
 * we are doing two things:
 *
 * Inserting/removing numbers from heaps of size ‘K’. This will take O(logK)O(logK)
 * Removing the element going out of the sliding window.
 * This will take O(K) as we will be searching this element in an
 * array of size ‘K’ (i.e., a heap).
 * Space complexity #
 * Ignoring the space needed for the output array,
 * the space complexity will be O(K) because,
 * at any time, we will be storing all the numbers within the sliding window.
 *
 * Removal or adding will need to rebalance heaps
 */
class SlidingWindowMedian {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);


    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        // TODO: Write your code here
        int p = 0;
        insertElem(nums,0, k - 1, result);
        result[p++] = findMedian();
        int i = k;
        int windowStart = 0;
        while(i < nums.length) {

            maxHeap.remove(nums[windowStart]);
            minHeap.remove(nums[windowStart]);
            rebalanceHeaps();
            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i])
                maxHeap.add(nums[i]);
            else
                minHeap.add(nums[i]);
            rebalanceHeaps();
            result[p++] = findMedian();

            i++;
            windowStart++;
        }
        return result;

    }

    private void rebalanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    private void insertElem(int[] nums, int start, int end, double[] result ) {

        for(int i = start; i <= end; i++ ) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i])
                maxHeap.add(nums[i]);
            else
                minHeap.add(nums[i]);

            // either both the heaps will have equal number of elements or max-heap will have one
            // more element than the min-heap
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            else if (maxHeap.size() < minHeap.size())
                maxHeap.add(minHeap.poll());
        }

    }

    private double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        double[] result2 = slidingWindowMedian.findSlidingWindowMedian(new int[]{7, 8, 8, 3, 8, 1, 5, 3, 5, 4}, 3);
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();
        System.out.print("Sliding window medians are: ");
        for (double num : result2)
            System.out.print(num + " ");
    }

}