package dp;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching_1024 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
//        int[][] arr = new int[][]{{3, 12}, {7, 14}, {9, 14}, {12, 15}, {0, 9}, {4, 14}, {2, 7}, {1, 11}};
//        int[][] arr = new int[][]{{3, 12}, {0, 9}, {2, 7}, {1, 11}, {4, 14}};
        int tar = 10;
//        int[][] arr = new int[][]{{0, 3}, {2, 6}, {0, 6}};
        System.out.println(videoStitching(arr, tar));
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
                } else
                    return -1;
            }
            return -1;
        });
//        return helper(clips, clips.length - 1, T);
        return 0;
    }

    //前i个clips 可以组成[0,T]的最小个数
//    static int helper(int[][] arr, int i, int T) {
//
//    }

    static int min3(int... nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < res) {
                res = nums[i];
            }
        }
        return res;
    }
}
