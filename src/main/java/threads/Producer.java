package threads;

import java.util.Queue;
import java.util.Random;

/**
 * @Author Mayank Gupta
 * @Date 11/15/17
 */
// Producer class which extends the
// thread
class Producer extends Thread {

    // Creating a string buffer
    StringBuffer buffer;
    boolean dp = false;

    // Initializing the string buffer
    Producer()
    {
        buffer = new StringBuffer(4);
    }

    // Overriding the run method
    public void run()
    {
        synchronized (buffer)
        {

            // Adding the data into the
            // buffer
            for (int i = 0; i < 4; i++) {
                try {
                    buffer.append(i);
                    System.out.println("Produced " + i);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Notifying the buffer
            System.out.println("Buffer is FUll");
            buffer.notify();
        }
    }
}