package queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Mayank Gupta
 * @Date 10/30/17
 */
public class PriorityQueueReverseOrder {


    public static void main(String args[]) {


        int[] inputs = new int[]{1,2,3,4,5,6,7,8};
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int k = 3;

        for(int i = 0; i < inputs.length; i++ ) {

            queue.add(inputs[i]);

            if(queue.size() > k ) {
                queue.poll();
            }
        }

        System.out.println(queue.poll());


    }
}
