package singleton;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author Mayank Gupta
 * @Date 9/8/17
 */
public class SingletonTest {

    private Thread t1;
    private Thread t2;

    @Before
    public void setUp() throws Exception {

        t1 = new Thread(new A());
        t2 = new Thread(new B());
    }

    @Test
    public void getInstance() throws Exception {

        t1.start();
        t2.start();


    }

    class A implements Runnable {


        @Override
        public void run() {
            System.out.println(Singleton.getInstance());
        }
    }

    class B implements Runnable {


        @Override
        public void run() {
            System.out.println(Singleton.getInstance());
        }
    }
}