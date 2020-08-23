package checkers;

import java.util.Arrays;

/**
 * @Description
 * @Date 2020/6/14 21:31
 **/
public class BinaryChecker {
    public static int findTheFirstGe(int[] arr, int target) {
        Arrays.sort(arr);
        for (int i : arr) {
            if (i >= target) {
                return i;
            }
        }
        return -1;
    }
}
