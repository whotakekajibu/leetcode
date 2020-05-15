package leetcode_cn.april;

import java.util.Arrays;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/4/11 21:55
 **/
public class TODO_Egg_drop_887 {
    public static void main(String[] args) {
//        System.out.println(superEggDrop(6, 5000));
//        System.out.println(superEggDropDp(2, 100));
        System.out.println(superEggDropDp(8, 10000));
    }

    public static int superEggDrop(int K, int N) {
        map = new int[N + 1][K + 1];
        for (int[] ints : map) {
            Arrays.fill(ints, -1);
        }
        return helper(N, K);
    }

    /**
     * @param k 鸡蛋数量
     * @param n 楼层高度
     * @return
     */
    public static int superEggDropDp(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (i == 1) {
                    dp[1][j] = j;
                }
                if (j == 1) {
                    dp[i][1] = 1;
                }
            }
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int tmp = Integer.MAX_VALUE;
                for (int t = 2; t <= j; t++) {
                    int broken = dp[i - 1][t - 1];
                    int notBroken = dp[i][j - t];
                    tmp = Math.min(Math.max(broken, notBroken) + 1, tmp);
                }
                dp[i][j] = tmp;
            }
        }
        return dp[k][n];
    }

    static int[][] map;

    public static int helper(int k, int n) {
        if (k == 0 || n == 0) {
            return 0;
        }
        System.out.println("楼层：" + k + "蛋： " + n);
        if (k == 1) {
            return 1;
        }
        if (n == 1) {
            return k;
        }
        if (map[k][n] != -1) {
            return map[k][n];
        }
        int res = 100;
        for (int i = 1; i <= k; i++) {
            int broken = helper(i - 1, n - 1);
            int notBroken = helper(k - i, n);
            int max = Math.max(broken, notBroken) + 1;
            res = Math.min(res, max);
        }
        return map[k][n] = res;
    }
}