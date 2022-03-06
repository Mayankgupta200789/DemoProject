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

        Producer producer = new Producer();

        Consumer consumer = new Consumer(producer);



        producer.start();
        consumer.start();
    }
}
