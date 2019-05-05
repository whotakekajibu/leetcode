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
            if (o1[1] > o2[1])
                return 1;
            else if (o1[1] == o2[1]) {
                if (o1[0] < o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0]) {
                    return 0;
                }
                return -1;
            } else {
                return -1;
            }
        });
        if (clips[clips.length - 1][1] < T) return -1;
        return helper(clips, clips.length - 1, T);
    }

    //前i个clips 可以组成[0,T]的最小个数
    static int helper(int[][] arr, int i, int T) {
        if (i == 0) {
            if (arr[i][1] >= T) {
                return 1;
            }
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        for (int j = i; j >= 0 && arr[j][1] >= T; j--) {
            if (arr[j][0] >= T) continue;
            int tmp = j, curT = arr[j][0];
            while (tmp >= 0 && (arr[tmp][1] < curT || arr[tmp][0] < curT)) {
                tmp--;
            }
            int t = helper(arr, tmp, curT);
            if (t != -1) {
                ans = Math.min(ans, t) + 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
