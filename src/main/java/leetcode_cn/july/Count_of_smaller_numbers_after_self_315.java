package leetcode_cn.july;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Date 2020/7/11 10:43
 **/
public class Count_of_smaller_numbers_after_self_315 {
    public static void main(String[] args) {
//        int[] arr = {5, 2, 6, 1};
        int[] arr = {2, 0, 1};
        for (Integer integer : countSmaller(arr)) {
            System.out.println(integer);
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        Integer[] dp = new Integer[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int cur = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    cur++;
                }
            }
            dp[i] = cur;
        }
        return Arrays.asList(dp);
    }
}
