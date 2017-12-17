package threads;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Mayank Gupta
 * @Date 11/15/17
 */
public class ProducerConsumerMain {



    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        Producer producer = new Producer(queue,5);

        Consumer consumer = new Consumer(queue);

        Thread a = new Thread(producer);
        Thread b = new Thread(consumer);

        a.start();
        b.start();
    }
}
