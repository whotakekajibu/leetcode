package dp.brutalrecursive;

import java.util.HashMap;
import java.util.Map;

public class CoinChange2_518 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5 };
		System.out.println(change(5, arr));
	}

	public static int change(int amount, int[] coins) {
		return helper(coins, 0, amount);
	}

	///////////////////////////////////// 暴力递归
	static Map<String, Integer> m = new HashMap<>();

	static int helper(int[] arr, int idx, int amount) {
		if (amount == 0) {
			return 1;
		}
		if (idx == arr.length) {
			return 0;
		}
		String key = idx + "_" + amount;
		if (m.get(key) != null)
			return m.get(key);
		int ans = 0;
		for (int i = 0; amount - i * arr[idx] >= 0; i++) {
			ans += helper(arr, idx + 1, amount - i * arr[idx]);
		}
		m.put(key, ans);
		return ans;
	}
	///////////////////////////////////////////// 暴力递归

	///////////////////////////////////////////// DP
	int dp(int am, int[] arr) {
		int[][] dp = new int[arr.length + 1][am + 1];
		for (int i = 0; i <= arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= am; i++) {
			dp[arr.length][i] = 0;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = am; j >= 1; j--) {
//				dp[i][j] = 
			}
		}
		return 0;
	}
	///////////////////////////////////////////// DP

}
