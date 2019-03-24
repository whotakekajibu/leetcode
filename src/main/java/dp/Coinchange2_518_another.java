package dp;

class Coinchange2_518_another {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(dp(500, coins));
    }

    public static int change(int amount, int[] coins) {
        return helper(coins, 0, amount);
    }

    public static int helper(int[] coins, int index, int amount) {
        int res = 0;
        if (index == coins.length) {
            return amount == 0 ? 1 : 0;
        } else {
            for (int i = 0; coins[index] * i <= amount; i++) {
                res += helper(coins, index + 1, amount - coins[index] * i);
            }
        }
        return res;
    }

    public static int dp(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[coins.length][0] = 1;
        for (int i = 1; i <= amount; i++) {
            dp[coins.length][i] = 0;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] += dp[i + 1][j];
                int tmp = j - coins[i];
                while (tmp >= 0) {
                    dp[i][j] += dp[i + 1][tmp];
                    tmp -= coins[i];
                }
            }
        }
        return dp[0][amount];
    }
}