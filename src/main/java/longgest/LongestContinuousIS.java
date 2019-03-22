package longgest;

public class LongestContinuousIS {
	public static void main(String[] args) {
		// int[] arr = { 1, 3, 5, 4, 7 };
		int[] arr = { 1, 3, 5, 4, 2, 3, 4 };
		System.out.println(findLengthOfLCIS(arr));
	}

	public static int findLengthOfLCIS(int[] nums) {
		int l = 0, r = 0;
		int res = 0;
		while (r < nums.length - 1) {
			if (nums[r + 1] > nums[r]) {
				res = Math.max(res, r - l + 1);
			} else {
				r++;
				l = r;
			}
		}
		return res;
	}
}
