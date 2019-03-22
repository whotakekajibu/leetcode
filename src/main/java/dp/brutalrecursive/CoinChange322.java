package dp.brutalrecursive;

import java.util.HashMap;
import java.util.Map;

public class CoinChange322 {
	public static void main(String[] args) {
		int[] arr = { 186, 419, 83, 408, 6249 };
		int amount = 1249;
		System.out.println(coinChange(arr, amount));
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

}
