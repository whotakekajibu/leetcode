package recursive.backtracking.permutation_46;

import java.util.ArrayList;
import java.util.List;

public class permutation_46 {
	public static void main(String[] args) {
		int[] st = { 1, 2, 3 };
		permute(st).stream().forEach(System.out::println);
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(nums, 0, res, list);
		return res;
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

}
