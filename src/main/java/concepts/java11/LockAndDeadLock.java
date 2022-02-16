package concepts.java11;


/**
 *
 * Commands to extract JFR for java 11
 * Run this command from C:\Program Files\Eclipse Adoptium\jdk-11.0.13.8-hotspot\bin>
 * 1) jcmd 30052 JFR.dump name=continuous filename=discovery.jfr
 * 2) jcmd 30052 JFR.dump name=continuous filename=discovery2.jfr
 * 3) jcmd 30052 JFR.stop name=continuous
 *
 *
 */
public class LockAndDeadLock {

    private static class AllocThread extends Thread {


        public void run() {
            while(true) {
                Thread.yield();

                try  {
                    Thread.sleep(20*1000);
                } catch (Exception e) {

                }

                for(int i = 0; i < 4000; i++ ) {
                    char[] temp = new char[1024*1024];
                    temp[1] = 'a';
                }
            }
        }
    }

    private static class LockerThread extends Thread {

        Object l1;
        Object l2;

        public void init(Object lock1,Object lock2) {
            l1 = lock1;
            l2 = lock2;
        }

        public void run() {
            while(true) {
                synchronized (l1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    synchronized (l2) {
                        try{
                            Thread.sleep(1000);

                        }catch (Exception e) {

                        }
                        System.out.println("Got one !!!");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        AllocThread allocThread = new AllocThread();
        Object lock1 = new Object();
        Object lock2 = new Object();

        LockerThread first = new LockerThread();
        LockerThread second = new LockerThread();

        first.init(lock1,lock2);
        second.init(lock2,lock1);

        allocThread.start();
        first.start();
        second.start();
    }

}
