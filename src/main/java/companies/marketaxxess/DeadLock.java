package companies.marketaxxess;

public class DeadLock {

    public class CustomThread extends Thread {

        private Object input1;
        private Object input2;

        public CustomThread(Object input1,Object input2) {

            this.input1 = input1;
            this.input2 = input2;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            synchronized (input1) {
                System.out.println("First input");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                synchronized (input2) {
                    System.out.println("Second input");
                }
            }
        }

    }

    public void createDeadLock() {

        Object input1 = new Object();
        Object input2 = new Object();

        CustomThread customThread1 = new CustomThread(input1, input2);
        CustomThread customThread2 = new CustomThread(input2, input1);

        customThread1.start();
        customThread2.start();


    }

    public static void main(String[] args) {
        new DeadLock().createDeadLock();
    }
}
