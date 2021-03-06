package Array.monostack.Larges_Rectangle_in_Histogram_84;

import java.util.ArrayDeque;
import java.util.Deque;

public class Larges_Rectangle_in_Histogram_simpler_84 {
    public static int largestRectangleArea(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        return answer(arr, 0, arr.length);
    }

    public static int answer(int[] arr, int start, int end) {
        if (end < start) {
            return 0;
        }
        if (end == start) {
            return arr[start];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        stack.push(start);
        for (int i = start + 1; i < end; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                Integer topIdx = stack.pop();
                int left;
                if (stack.isEmpty()) {
                    left = start - 1;
                } else {
                    left = stack.peek();
                }
                res = Math.max(res, arr[topIdx] * (i - left - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                res = Math.max(res, arr[stack.peek()] * (end - start));
                break;
            }
            Integer top = stack.pop();
            res = Math.max(res, (end - stack.peek() - 1) * arr[top]);
        }
        return res;
    }

    // Driver program
    public static void main(String[] args) {
//        int[] histogram = {1};
//        int[] histogram = {5, 4, 1, 2};
//        int[] histogram = {4, 3, 2, 5, 6};
//        int[] histogram = {2, 1, 5, 6, 2, 3};
//        int[] histogram = {4, 2, 0, 3, 2, 5};
//        int[] histogram = {3, 6, 5, 7, 4, 8, 1};
//        int[] histogram = {3,3,6,6,7};
        int[] histogram = {0, 0};
        System.out.println(largestRectangleArea(histogram));
    }


}
