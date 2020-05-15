package leetcode_cn.april;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/4/22 22:14
 **/
public class Merge_intervals_56_2020_0422 {

    public static void main(String[] args) {
//        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr = {{1, 4}, {0, 0}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return helper(o1, o2, 0);
            }

            int helper(int[] o1, int[] o2, int idx) {
                if (idx == 2) {
                    return 0;
                }
                if (o1[idx] < o2[idx]) {
                    return -1;
                } else if (o1[idx] > o2[idx]) {
                    return 1;
                } else {
                    return helper(o1, o2, idx + 1);
                }
            }
        });
        int[][] ans = new int[intervals.length][2];
        ans[0][0] = intervals[0][0];
        ans[0][1] = intervals[0][1];
        helper(intervals, 1, ans, 0);
        int len = 1, idx = 1;
        while (idx < ans.length && (ans[idx][0] != 0 || ans[idx][1] != 0)) {
            len++;
            idx++;
        }
        if (len == ans.length) {
            return ans;
        }
        return Arrays.copyOf(ans, len);
    }

    public static void helper(int[][] intervals, int i, int[][] ans, int idx) {
        if (i >= intervals.length) {
            return;
        }
        if (intervals[i][0] <= ans[idx][1]) {
            if (intervals[i][1] >= ans[idx][1]) {
                ans[idx][1] = intervals[i][1];
            }
            helper(intervals, i + 1, ans, idx);
        } else {
            ans[idx + 1][0] = intervals[i][0];
            ans[idx + 1][1] = intervals[i][1];
            helper(intervals, i + 1, ans, idx + 1);
        }
    }

}
