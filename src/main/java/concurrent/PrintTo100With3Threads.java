package concurrent;

/**
 * @Description
 * @Date 2020/6/24 11:20
 **/
public class PrintTo100With3Threads {
    private static volatile int number = 1;
    private static Object obj = new Object();

    public static void main(String[] args) {
        PrintWithNotify();
    }

    private static void PrintWithNotify() {
        Thread t1 = new Thread(new Printer(1));
        Thread t2 = new Thread(new Printer(2));
        Thread t3 = new Thread(new Printer(0));
        t1.start();
        t2.start();
        t3.start();
    }

    static class Printer implements Runnable {
        private int threadId;

        public Printer(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            try {
                while (number <= 100) {
                    synchronized (obj) {
                        if (number % 3 != threadId) {
                            obj.wait();
                        } else {
                            System.out.println(Thread.currentThread().getName() + ":" + number++);
                            obj.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
