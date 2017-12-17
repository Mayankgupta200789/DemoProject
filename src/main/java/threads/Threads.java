package threads;

/**
 * @Author Mayank Gupta
 * @Date 11/8/17
 */
public class Threads {


    private int count;

    private boolean flag;

    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Threads threads = new Threads();

        threads.validate();


    }

    private void validate() throws InterruptedException {

        A a = new A();
        B b = new B();
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(b);

        thread1.start();

        thread2.start();


    }

    public class A implements Runnable {


        @Override
        public void run() {

            while (true) {
                synchronized (lock) {
                    System.out.println("Value of count from thread A is " + count++);
                    flag = true;
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public class B implements Runnable {

        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    if (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Value of count from thread B is " + count++);
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
