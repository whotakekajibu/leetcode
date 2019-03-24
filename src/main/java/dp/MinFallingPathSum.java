package dp;

import java.util.HashMap;
import java.util.Map;

public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] arr = {{51, 24}, {-50, 82}};
        System.out.println(minFallingPathSum(arr));
    }

    public static int minFallingPathSum(int[][] A) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            res = Math.min(res, helper(A, A.length - 1, i));
        }
        return res;
    }

    static Map<String, Integer> m = new HashMap<>();

    static int helper(int[][] arr, int i, int j) {
        if (i == 0) {
            if (j >= arr[0].length || j < 0)
                return Integer.MAX_VALUE;
            else {
                return arr[i][j];
            }
        } else {
            if (m.get(i + "_" + j) != null) {
                return m.get(i + "_" + j);
            }
            if (j < 0 || j >= arr[0].length)
                return Integer.MAX_VALUE;
            int righttop = helper(arr, i - 1, j + 1);
            int lefttop = helper(arr, i - 1, j - 1);
            int top = helper(arr, i - 1, j);
            int res = minOf3(lefttop, top, righttop) + arr[i][j];
            m.put(i + "_" + j, res);
            return res;
        }

    }

    static int minOf3(int a, int b, int c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }
}
