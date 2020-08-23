package singleton;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @Description
 * @Date 2020/5/22 17:32
 **/
public class Singleton_DCL {
    public static void main(String[] args) {

    }

    private static volatile Singleton_DCL instance;

    private Singleton_DCL() {
    }

    public static Singleton_DCL getInstance() {
        if (instance == null) {
            synchronized (Singleton_DCL.class) {
                if (instance == null) {
                    instance = new Singleton_DCL();
                }
            }
        }
        return instance;
    }

}
