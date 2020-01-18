package dp.longest.LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/1/3 22:49
 **/
public class LongestIncreasingSubsequence_300_20190103_recursive {
    public static void main(String[] args) {
        int[] arr = {10,10};
        System.out.println(lengthOfLIS(arr));
    }

    /**
     * Input: [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101],
     * therefore the length is 4.
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        helper(nums, ans, 1);
        int res = 1;
        for (int an : ans) {
            res = Math.max(res, an);
        }
        return res;
    }

    public static void helper(int[] arr, int[] ans, int idx) {
        if (idx == arr.length) {
            return;
        }
        for (int i = 0; i < idx; i++) {
            if (arr[idx] > arr[i]) {
                ans[idx] = Math.max(ans[idx], ans[i] + 1);
            }
        }
        helper(arr, ans, idx + 1);
    }
}
