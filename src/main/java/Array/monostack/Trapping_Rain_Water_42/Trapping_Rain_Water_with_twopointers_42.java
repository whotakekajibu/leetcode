package Array.monostack.Trapping_Rain_Water_42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * @Date 2020/4/1 8:14
 **/
public class Trapping_Rain_Water_with_twopointers_42 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return 0;
        }
        int left = 0, right = 1;
        while (right < arr.length) {
            if (right - left == 1){

            }
        }
        return 0;
    }
}
