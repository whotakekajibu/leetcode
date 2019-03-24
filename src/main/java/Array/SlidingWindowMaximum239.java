package Array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[] arr = new int[0];
//        Utils.printArray(maxSlidingWindow(arr,0));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> qmax = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qmax.isEmpty() && nums[i] >= nums[qmax.peekLast()]) {
                qmax.pollLast();
            }
            qmax.offer(i);
            if (i - k == qmax.peekFirst()) {
                qmax.pollFirst();
            }
            if (i >= k - 1) {
                res[idx++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
}
