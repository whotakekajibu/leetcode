package leetcode_cn.contest;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Date 2020/4/18 21:20
 **/
public class MinJump_LCP09 {

    public static void main(String[] args) {
//        int[] arr = {2, 5, 1, 1, 1, 1};
//        int[] arr = {1, 1, 1};
//        int[] arr = {2, 8, 1, 10, 1, 2, 6, 9, 2, 4, 4, 2, 3, 2, 5, 5, 1};
        int[] arr = {2, 8, 1, 10, 1, 8, 10, 9, 2, 6, 9, 2, 4, 4, 2, 3, 2, 5, 5, 1, 4, 2, 8, 3, 3, 2, 8, 1, 4, 9, 5, 10, 8, 1, 5, 5, 5, 6, 10, 2, 10, 1, 7, 4, 3, 6, 4, 2, 10, 1, 5, 7, 5, 4, 7, 6, 9, 3, 7, 8, 3, 9, 7, 4, 7, 7, 2, 3, 9, 6, 4, 5, 9, 2, 2, 5, 10, 10, 6, 9, 7, 2, 4, 2, 2, 6, 9, 8, 8, 3, 10, 10, 2, 9, 9, 4, 6, 7, 10, 4};
//        int[] arr = {3, 7, 6, 1, 4, 3, 7, 8, 1, 2, 8, 5, 9, 8, 3, 2, 7, 5, 1, 1};
//        int[] arr = {9,8,3,2,7,5,1,1};
//        int[] arr = {3, 1, 2, 1, 2, 3};
        System.out.println(minJumpBfs(arr));
    }

    public static int minJumpBfs(int[] arr) {

        if (arr == null || arr.length == 0 || arr.length == 1 && arr[0] == 0) {
            return Integer.MAX_VALUE;
        }
        if (arr.length == 1) {
            return 1;
        }

/*        if (arr.length == 1) {
            return 1;
        }
        if (arr[0] > arr.length - 1) {
            return 2;
        }
        if (arr[0] == arr.length - 1) {
            return 3;
        }*/
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[arr.length];
        int step = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            int ans = Integer.MAX_VALUE;
            boolean find = false;
            while (len > 0) {
                len--;
                Integer poll = q.poll();
                if (poll + arr[poll] > arr.length - 1) {
                    return step + 1;
                }
                if (poll + arr[poll] == arr.length - 1) {
                    find = true;
                    ans = Math.min(step + 2, ans);
                    continue;
                }
                if (!visited[poll + arr[poll]]) {
                    q.offer(poll + arr[poll]);
                    visited[poll + arr[poll]] = true;
                }
                for (int i = poll - 1; i >= 1; i--) {
                    if (!visited[i]) {
                        q.offer(i);
                        visited[i] = true;
                    }
                }
            }
            if (find) {
                return ans;
            }
            step++;
        }
        return step;
    }

}
