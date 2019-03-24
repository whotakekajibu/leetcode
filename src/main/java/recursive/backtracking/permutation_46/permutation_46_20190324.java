package recursive.backtracking.permutation_46;

import java.util.ArrayList;
import java.util.List;

public class permutation_46_20190324 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permute(arr).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permute(nums, 0, output);
        return output;
    }

    static void permute(int[] nums, int cur, List<List<Integer>> output) {
        if (cur == nums.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i : nums) {
                list.add(i);
            }
            output.add(list);
            return;
        }
        for (int i = cur ; i < nums.length; i++) {
            // swap nums[cur] and nums[i]
            int temp = nums[cur];
            nums[cur] = nums[i];
            nums[i] = temp;

            permute(nums, cur + 1, output);

            // swap nums[cur] and nums[i]
            temp = nums[cur];
            nums[cur] = nums[i];
            nums[i] = temp;
        }
    }
}
