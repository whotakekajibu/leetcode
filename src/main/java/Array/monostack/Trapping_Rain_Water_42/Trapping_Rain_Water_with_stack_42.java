package Array.monostack.Trapping_Rain_Water_42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * @Date 2020/4/1 8:14
 **/
public class Trapping_Rain_Water_with_stack_42 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                int topIdx = stack.poll();
                int height;
                if (stack.isEmpty() || arr[topIdx] == arr[i]) {
                    break;
                } else {
                    height = Math.min(arr[stack.peek()], arr[i]);
                }
                int wholeArea = height * (i - stack.peek() - 1);
                for (int j = stack.peek() + 1; j < i; j++) {
                    wholeArea -= arr[j];
                    arr[j] = height;
                }
                res += wholeArea;
            }
            stack.push(i);
        }
        return res;
    }
}
