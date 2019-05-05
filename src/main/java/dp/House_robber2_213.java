package dp;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class House_robber2_213 {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] arr = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        lengthOfLIS(arr);
    }

    public static int rob(int[] arr) {
        int[][] memo = new int[arr.length][arr.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return helper(arr, 0, arr.length - 1, memo);
    }

    static int helper(int[] arr, int begin, int end, int[][] memo) {
        if (begin > end) return 0;
        if (begin == end) return arr[begin];
        if (memo[begin][end] != -1) return memo[begin][end];
        int taken = 0, nottaken = 0;
        if (begin == 0) {
            end -= 1;
        }
//        if (begin == 0) {
//            taken = arr[begin] + helper(arr, begin + 2, end - 1, memo);
//            nottaken = helper(arr, begin + 1, end, memo);
//        } else {
//            taken = arr[begin] + helper(arr, begin + 2, end, memo);
//            nottaken = helper(arr, begin + 1, end, memo);
//        }
        taken = arr[begin] + helper(arr, begin + 2, end, memo);
        nottaken = helper(arr, begin + 1, end, memo);
        return memo[begin][end] = Math.max(taken, nottaken);
    }


    static int lengthOfLIS(int[] arr) {
        int res = 1;
        int[] resultArr = new int[0];
        int cnt = (int) Math.pow(2, arr.length);
        for (int i = 0; i < cnt; i++) {
            int len = bitCnt(i);
            if (len <= 0) continue;
            int[] tmpArr = new int[len];
            int t = i, idx = len - 1, arrLen = arr.length - 1;
            while (t != 0) {
                if ((t & 1) == 1) {
                    tmpArr[idx--] = arr[arrLen];
                }
                arrLen--;
                t = t >> 1;
            }
            if (valid(tmpArr)) {
                if (res < tmpArr.length) {
                    resultArr = tmpArr;
                    res = resultArr.length;
                }
            }
        }
        for (int i : resultArr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(res);
        return res;
    }

    static boolean valid(int[] arr) {
        int s = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= s) {
                return false;
            }
            s = arr[i];
        }
        return true;
    }
    static int bitCnt(int i) {
        int res = 0;
        while (i != 0) {
            res++;
            i = i & (i - 1);
        }
        return res;
    }


}
