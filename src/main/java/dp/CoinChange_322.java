package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoinChange_322 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 5 };
		
	}

	public static int coinChange(int[] coins, int amount) {
		m.clear();
		if (coins.length == 1) {
			float res = (float) amount / (coins[0]);
			int counter = (int) res;
			if (res - counter == 0) {
				return (int) res;
			} else {
				return -1;
			}
		}
		return helper(amount, coins, 0);
	}

	//////////////////////////////// brutal force
	//////////////////////////////// recursion(TLE)////////////////////////
	static Map<String, Integer> m = new HashMap<>();

	static int helper(int tar, int[] arr, int cnt) {
		if (tar < 0)
			return -1;
		if (tar == 0)
			return cnt;
		String key = tar + "_" + cnt;
		if (m.get(key) != null)
			return m.get(key);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int t = helper(tar - arr[i], arr, cnt + 1);
			if (i != arr.length - 1) {
				if (t == -1)
					continue;
				else {
					res = Math.min(res, t);
				}
			} else {
				if (t == -1) {
					if (res == Integer.MAX_VALUE) {
						return -1;
					}
				} else {
					res = Math.min(res, t);
				}
			}
		}
		m.put(key, res);
		return res;
	}

	//////////////////////////////// dp(N*M*M)////////////////////////
	public static int coinChangeWithdp(int[] arr, int amount) {
		int len = arr.length + 1;
		int[][] dp = new int[len][amount + 1];
		for (int i = 0; i < len; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i < amount + 1; i++) {
			dp[len - 1][i] = -1;
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = 0; j <= amount; j++) {
				int ans = Integer.MAX_VALUE;
				for (int cnt = 0; j >= cnt * arr[i]; cnt++) {
					int cd = dp[i + 1][j - cnt * arr[i]];
					if (cd != -1) {
						ans = Math.min(ans, cnt + cd);
					}
				}
				dp[i][j] = ans == Integer.MAX_VALUE ? -1 : ans;
			}
		}
		return dp[0][amount];
		// return coinChange(0, coins, amount);
	}

	////////////////////////// dp（O(N*M)）///////////////////////////
	public int coinChangeNM(int[] arr, int amount) {
		int len = arr.length + 1;
		int[][] dp = new int[len][amount + 1];
		for (int i = 0; i < len; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i < amount + 1; i++) {
			dp[len - 1][i] = -1;
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = 1; j <= amount; j++) {
				int ans = Integer.MAX_VALUE;
				if (j >= arr[i]) {
					int pre = j - arr[i];
					if (dp[i + 1][j] == dp[i][pre] || dp[i][pre] == -1) {
						dp[i][j] = dp[i + 1][j];
						continue;
					}
					ans = Math.min(ans, dp[i][pre] + 1);
				}
				if (dp[i + 1][j] != -1) {
					ans = Math.min(ans, dp[i + 1][j]);
				}
				ans = ans == Integer.MAX_VALUE ? -1 : ans;
				dp[i][j] = ans;
			}
		}
		return dp[0][amount];
	}

	//////////////////////////// brutal force (O(2^N))//////////////////////
	private static int coinChange(int i, int[] arr, int amount) {
		if (amount == 0)
			return 0;
		if (i == arr.length)
			return -1;
		int ans = Integer.MIN_VALUE;
		for (int j = 0; amount - j * arr[i] >= 0; j++) {
			int res = coinChange(i + 1, arr, amount - j * arr[i]);
			if (res != -1)
				ans = Math.min(ans, res + j);
		}
		ans = ans == Integer.MAX_VALUE ? -1 : ans;
		return ans;
	}
	//////////////////////////// backtracking//////////////////////

}
