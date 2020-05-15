package leetcode_cn.april;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/4/23 22:17
 **/
public class Coins_2020_04_23 {
    public static void main(String[] args) {
        System.out.println(waysToChange(900750));
    }

    public static int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[5][n + 1];
        dp[4][0] = 1;
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j - coins[i] >= 0) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
                dp[i][j] %= 1000000007;
            }
        }
        return dp[0][n];
    }
}
