package dp;

public class IntegerBreak_343 {

	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}

	public static int integerBreak(int n) {
		if (n == 1)
			return 1;
		int res = 0;
		for (int i = 1; i < n; i++) {
			res = Math.max(res, Math.max(integerBreak(n - i) * i, i * (n - i)));
		}
		return res;
	}

	public static int integerBreakDP(int n) {
		return 0;
	}
}
