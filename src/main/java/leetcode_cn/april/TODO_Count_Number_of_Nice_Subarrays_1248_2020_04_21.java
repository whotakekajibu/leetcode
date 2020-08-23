package leetcode_cn.april;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Date 2020/4/21 14:54
 **/
public class TODO_Count_Number_of_Nice_Subarrays_1248_2020_04_21 {
    /**
     * 输入：nums = [1,1,2,1,1], k = 3
     * 输出：2
     * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 1, 1};
//        int[] arr = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int[] arr = {2, 4, 6};
        System.out.println(numberOfSubarrays(arr, 1));
    }

    public static int numberOfSubarrays(int[] arr, int k) {
        int l = 0, r = 0, oddCnt = 0, ans = 0;
        Deque<Integer> q = new LinkedList<>();
        while (r < arr.length) {
            int cur = arr[r++];
            if (cur % 2 == 1) {
                oddCnt++;
                q.offer(r - 1);
            }
            if (oddCnt == k + 1) {
                Integer last = q.pollLast();
                ans += (q.peekFirst() - l + 1) * (last - q.peekLast());
                l = q.pollFirst() + 1;
                q.offer(last);
                oddCnt--;
            }
            if ((oddCnt == k || oddCnt == k + 1) && r == arr.length && !q.isEmpty()) {
                ans += (q.peekFirst() - l + 1) * (r - q.peekLast());
            }
        }
        return ans;
    }
}
