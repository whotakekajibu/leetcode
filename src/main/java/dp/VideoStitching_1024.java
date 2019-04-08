package dp;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching_1024 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        System.out.println(videoStitching(arr, 10));
    }

    public static int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] <= o2[0] && o1[1] >= o2[1])
                return 1;
            else if (o1[0] <= o2[0]) {
                return -1;
            } else if (o1[1] >= o2[1]) {
                return 1;
            } else {
                return -1;
            }
        });

        return helper(clips, clips.length - 1, T);
    }

    //前i个clips 可以组成[0,T]的最小个数
    static int helper(int[][] arr, int i, int T) {
        if (i == 0) {
            if (arr[i][1] >= T)
                return 1;
            return -1;
        }
        if (arr[i][1] < T)
            return -1;
        else if (arr[i][0] > T) {
            return helper(arr, i - 1, T);
        }
        int res = Integer.MAX_VALUE;
        int idx = i;
        while (idx >= 0 && arr[idx][0] >= T && arr[idx][1] <= T) {
            int ans = helper(arr, idx, arr[idx][0]);
            if (ans != -1) {
                res = Math.min(res, ans);
            }
            idx--;
        }
        return res == Integer.MAX_VALUE ? -1 : res + 1;

    }
}
