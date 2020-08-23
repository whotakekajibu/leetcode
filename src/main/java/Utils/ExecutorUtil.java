package Utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 此类的描述是：
 *
 * @author crazyhu@wezhuiyi.com
 * @date 2018-12-20 16:49
 **/
public class ExecutorUtil {

    /**
     * CPU 的堵塞系数
     */
    private static final double BLOCKING_COEFFICIENT = 0.8;

    private static ThreadPoolExecutor executor;

    private static Map<Integer, ThreadPoolExecutor> batchExecutor = new ConcurrentHashMap<>();

    static {
        executor = newIoIntensiveThreadPool("common-executor");
    }

    private ExecutorUtil() {
    }

    public static ThreadPoolExecutor getExecutor() {
        return executor;
    }

    /**
     * 以busId为key，每个业务一个线程池
     *
     * @return
     */
    public static Map<Integer, ThreadPoolExecutor> getBatchExecutor() {
        return batchExecutor;
    }

    /**
     * IO 密集型线程池
     *
     * @param poolNameFormat 线程池名字的格式，例如: name-pool-%d
     * @return IO 密集型线程池
     */
    public static ThreadPoolExecutor newIoIntensiveThreadPool(String poolNameFormat) {
        Integer processors = Runtime.getRuntime().availableProcessors();
//        int coreSize = (int) (processors / (1 - BLOCKING_COEFFICIENT));
        int coreSize = 100;
        return createFixedThreadPool(poolNameFormat, coreSize);
    }

    /**
     * CPU 密集型线程池
     *
     * @param poolNameFormat 线程池名字的格式，例如: name-pool-%d
     * @return CPU 密集型线程池
     */
    public static ThreadPoolExecutor newCpuIntensiveThreadPool(String poolNameFormat) {
        int coreSize = Runtime.getRuntime().availableProcessors() + 1;
        return createFixedThreadPool(poolNameFormat, coreSize);
    }

    /**
     * 构造线程池
     *
     * @param poolNameFormat 线程池名字的格式，例如: name-pool-%d
     * @param coreSize       核心线程个数
     * @return 创建固定线程数目的线程池
     */
    public static ThreadPoolExecutor createFixedThreadPool(String poolNameFormat, int coreSize) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat(poolNameFormat)
                .build();
        return new ThreadPoolExecutor(coreSize,
                coreSize,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                threadFactory);
    }

    /**
     * 根据 hourAndminutes 生成Spring 风格(6位)的的cron表达式
     *
     * @param hourAndminute
     * @return
     */
    public static String generateCronExp(String hourAndminute) {
        Integer hour = Integer.valueOf(hourAndminute.substring(0, 2));
        Integer minute = Integer.valueOf(hourAndminute.substring(2));
        String cronExp = "* " + minute + " " + hour + " * * ?";
        return cronExp;
    }


}