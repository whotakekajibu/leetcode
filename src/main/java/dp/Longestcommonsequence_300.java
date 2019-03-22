package dp;

public class Longestcommonsequence_300 {

	public static void main(String[] args) {

	}

	public static int[] m;

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = 1;
		m = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res = Math.max(res, helper(nums, i));
		}
		return res;
	}

	static int helper(int[] nums, int idx) {
		if (idx == 0)
			return 1;
		if (m[idx] != 0)
			return m[idx];
		int res = 1;
		for (int i = 0; i <= idx; i++) {
			if (nums[i] < nums[idx]) {
				res = Math.max(res, helper(nums, i) + 1);
			}
		}
		m[idx] = res;
		return res;
	}

	////////////////////// method 2 dynamic programming
	public static int lengthOfLISDP(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		// int[] dp = new int[nums.length];
		return 0;
	}

}
