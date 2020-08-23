package dp.best_time_to_buy_and_sell_stock_with_transaction_fee;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.Map;

/**
 * @Description
 * @Date 2020/7/12 22:21
 **/
public class Best_time_to_buy_and_sell_stock_with_transaction_fee_714 {
 /*   public static void main(String[] args) {
        int[] arr = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(arr, fee));
    }*/

    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][3]) + prices[i] - fee;
            dp[i][3] = Math.max(dp[i - 1][0], dp[i - 1][2]) - prices[i];
        }
        return Math.max(Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]), Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }

    /**
     * dp[i][j] =
     *
     * @param
     * @return
     */
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 11, 13};
        int[] count = {1, 2, 3, 4, 5};
        int money = 30;
        System.out.println(min(arr, count, money));
/*        int[] arr = {1, 2};
        int m = 4;
        System.out.println(Main(arr, m));*/
    }

    static int min(int[] arr, int[] count, int money) {
        int sum = 0;
        for (int i : count) {
            sum += i;
        }
        return helper(arr, count, 0, money, sum);
    }

    public static int helper(int[] arr, int[] count, int i, int money, int max) {
        if (money < 0 || i >= arr.length) {
            return max;
        }
        if (money == 0) {
            return 0;
        }
        if (i == arr.length - 1) {
            for (int j = 1; j <= count[i]; j++) {
                money -= j * arr[i];
                if (money == 0) {
                    return j;
                }
            }
            return max;
        }
        int ans = max;
        for (int c = 0; c <= count[i] && money - c * arr[i] >= 0; c++) {
            int cur = c + helper(arr, count, i + 1, money - c * arr[i], max);
            ans = Math.min(ans, cur);
        }
        return ans;
    }

    public static int Main(int[] arr, int m) {
        int[][] memo = new int[m + 1][arr.length + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return helper(m, 0, arr, memo);
    }

    public static int helper(int m, int idx, int[] arr, int[][] memo) {
        if (idx == arr.length) {
            return m == 0 ? 1 : 0;
        }
        if (m == 0) {
            return 1;
        }
        if (memo[m][idx] != -1) {
            return memo[m][idx];
        }
        int ans = 0;
        for (int j = 0; m - j * arr[idx] >= 0; j++) {
            ans += helper(m - j * arr[idx], idx + 1, arr, memo);
        }
        return memo[m][idx] = ans;
    }

    public int change(int amount, int[] arr) {
        int[][] dp = new int[arr.length + 1][amount + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            dp[arr.length][i] = 0;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] += dp[i + 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[0][amount];
    }
}
