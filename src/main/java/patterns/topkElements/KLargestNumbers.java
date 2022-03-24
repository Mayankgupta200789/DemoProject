package patterns.topkElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i++ ) {
            queue.add(nums[i]);
            if(queue.size() > k ){
                queue.poll();
            }
        }

        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
