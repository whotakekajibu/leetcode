package recursive;

import java.util.ArrayList;
import java.util.List;

public class permutation {
	public static void main(String[] args) {
		int[] st = { 1, 2, 3 };
		// List<String> res = new ArrayList<>();
		// res.stream().forEach(System.out::println);
		// permute(st);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(rev(1534236469));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(nums, 0, res, list);
		return null;
	}

	static void helper(int[] nums, int i, List<List<Integer>> res, List<Integer> list) {
		if (i == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int j = i; j < nums.length; j++) {
			list.add(nums[i]);
			helper(nums, i + 1, res, list);
			list.remove(list.size() - 1);
		}
	}

	static int rev(int n) {
		boolean flag = false;
		if (n < 0) {
			flag = true;
			n = -n;
		}
		long res = 0;
		int b = 0;
		while (n > 0) {
			b = n % 10;
			n = n / 10;
			res = 10 * res + b;
			if (Integer.MAX_VALUE < res) {
				return 0;
			}
		}
		if (flag)
			return (int) -res;
		return (int) res;
	}

}
