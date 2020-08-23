package concurrent;

/**
 * @Description
 * @Date 2020/6/24 11:32
 **/
public class PrintOddEvenUsing2Threads {
    private static volatile int num = 1;
    private static Object obj = new Object();

    public static void main(String[] args) {
        Thread even = new Thread(new Print(0));
        even.setName("偶数线程");
        Thread odd = new Thread(new Print(1));
        odd.setName("奇数线程");
        even.start();
        odd.start();
    }

    static class Print implements Runnable {
        private int threadId;

        public Print(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            try {
                while (num <= 100) {
                    synchronized (obj) {
                        if (num % 2 == threadId) {
                            System.out.println(Thread.currentThread().getName() + "" + num++);
                            obj.notify();
                        } else {
                            obj.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {

            }
        }
    }
}
