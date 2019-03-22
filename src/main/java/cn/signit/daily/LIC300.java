package cn.signit.daily;

import java.util.Random;

public class LIC300 {

	public static void main(String[] args) {
		int[] arr = { 42439, 46334, 51617, 33674, 51666, 31603, 45524, 50349, 31392, 37803, 31090, 47110, 39963, 44606,
				28768, 35801, 37978, 36167, 44542, 53425, 43886, 27371, 43772, 34550, 40659, 44712, 50628, 30587, 42184,
				50838, 38253, 43544, 34418, 26987, 35824, 33853, 32657, 52386, 52176, 27122, 32589, 40977, 32266, 45123,
				36178, 48483, 48004, 31935, 32115, 26872, 45891, 33333, 38642, 49177, 41993, 51660, 32009, 43719, 42190,
				45372, 41866, 48275, 39083, 45241, 27039, 43939, 27601, 38517, 54649, 37588, 47458, 36343, 41949, 38439,
				26103, 52833, 44860, 32161, 27474, 47189, 39321, 39659, 45901, 50229, 50136, 54701, 43282, 42463, 53988,
				40997, 26471, 51923, 35985, 44495, 34331, 31738, 46266, 37368, 30572, 47404 };
		int min = arr[0], max = arr[0], minidx = 0, maxidx = 0;
		// for (int i = 1; i < arr.length; i++) {
		// if (arr[i] > max) {
		// max = arr[i];
		// maxidx = i;
		// } else if (arr[i] < min) {
		// min = arr[i];
		// minidx = i;
		// }
		// }
		// System.out.println("最大的数是: " + max + "索引是：" + (maxidx + 2) + "最小的数是:"
		// + min + "索引是：" + (minidx + 2));
		// int[] arr = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		// System.out.println(lengthOfLIS(arr));
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			int res = r.nextInt(900);
			while (i <= 40 && res < 150 || res < 100) {
				res = r.nextInt(900);
			}
			while (res > 800 && i >= 40) {
				res = r.nextInt(800);
			}
			System.out.println(res);
		}
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
		int[] dp = new int[nums.length];
		return 0;
	}

}
