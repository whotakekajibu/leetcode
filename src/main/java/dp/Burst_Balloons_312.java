package dp;

import java.util.Map;

/**
 * @Description Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * @Date 2020/1/19 0:16
 **/
public class Burst_Balloons_312 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 8};
        System.out.println(maxCoins(arr));
    }

    public static int maxCoins(int[] nums) {
        int[] padding = new int[nums.length + 2];
        padding[0] = 1;
        for (int i = 1; i <= padding.length - 2; i++) {
            padding[i] = nums[i - 1];
        }
        padding[padding.length - 1] = 1;
        return helper(padding, 1, padding.length - 2);
    }

    /**
     * 131581
     *
     * @param arr
     * @param
     * @return
     */
    public static int helper(int[] arr, int left, int right) {
        if (left > right) {
            return 0;
        }
        System.out.println("left= " + left + "right= " + right);
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int leftCoin = helper(arr, left, i - 1);
            int righCoin = helper(arr, i + 1, right);
            ans = Math.max(ans, arr[i] * arr[left - 1] * arr[right + 1] + leftCoin + righCoin);
        }
        return ans;
    }
}
