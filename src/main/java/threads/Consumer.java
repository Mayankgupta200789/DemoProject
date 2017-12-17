package threads;

import java.util.Queue;

/**
 * @Author Mayank Gupta
 * @Date 11/15/17
 */
public class Consumer extends Thread {

    private Queue<Integer> queue;

    private int maxSize;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {


                if (!queue.isEmpty()) {
                    synchronized (queue) {
                        System.out.println("Input consumed " + queue.remove());
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


        }

    }
}
