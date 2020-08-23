package concurrent;

import Utils.ExecutorUtil;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Date 2020/6/13 14:36
 **/
public class ThreadSafeTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.shutdown();
        for (int i = 0; i < 100; i++) {
            int fi = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(fi);
                }
            });
        }
    }
}
