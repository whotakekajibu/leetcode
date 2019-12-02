package recursive.backtracking.permutation_46;

import java.util.ArrayList;
import java.util.List;

public class permutation_46_20190512 {

    static List<String> permutation(int[] num) {
        List<String> res = new ArrayList<>(fac(num.length));
        if (num == null || num.length == 0) {
            return res;
        }
        dfs(res, num, 0, new StringBuilder());
        return res;
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3};
        System.out.println(permutation(s));
    }

    static int fac(int n) {
        if (n <= 2) {
            return n;
        }
        return n * fac(n - 1);
    }

    static void dfs(List<String> res, int[] nums, int cur, StringBuilder sb) {
        if (nums.length == cur) {
            for (int c : nums) {
                sb.append(c);
            }
            res.add(sb.toString());
            sb.setLength(0);
        } else {
            for (int i = cur; i < nums.length; i++) {
                swap(nums, cur, i);
                dfs(res, nums, cur + 1, sb);
                swap(nums, cur, i);
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
