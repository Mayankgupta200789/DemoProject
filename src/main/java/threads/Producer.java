package threads;

import java.util.Queue;
import java.util.Random;

/**
 * @Author Mayank Gupta
 * @Date 11/15/17
 */
public class Producer extends Thread {

    private Queue<Integer> queue;

    private int maxSize;

    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (queue) {

                while (queue.size() == maxSize) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (queue) {

                Random random = new Random();
                int input = random.nextInt(1000);
                System.out.println("Input produced " + input);
                queue.add(input);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                queue.notifyAll();
            }


        }
    }
}
