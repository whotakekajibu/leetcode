package Utils;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2019/10/20 23:16
 **/
public class BigDataOperationChecker {

    public static void main(String[] args) {
        Random random = new Random();
        for (long i = 0; i < 1000L; i++) {
            String a = random.nextInt(10000) + "";
            String b = random.nextInt(10000) + "";
            checker(a, b);
        }
    }

    public static void checker(String... strs) {
        if (!add(strs[0], strs[1]).equals(MathUtils.add(strs[0], strs[1]))) {
            System.err.println(strs[0] + "-" + strs[1]);
        }
    }

    public static String add(String... strings) {
        BigInteger res = new BigInteger(strings[0]);
        for (int i = 1; i <= strings.length - 1; i++) {
            res = res.add(new BigInteger(strings[i]));
        }
        return res.toString();
    }

    public static String pow(String big) {
        BigInteger res = new BigInteger(big).pow(3);
        System.out.println(res.toString());
        return res.toString();
    }
}
