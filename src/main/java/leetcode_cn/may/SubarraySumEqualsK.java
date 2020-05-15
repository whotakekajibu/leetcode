package leetcode_cn.may;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/5/15 19:34
 **/
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {-1, -1, 1};
        int k = 0;
        System.out.println(subarraySum(arr, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; j >= 0; j--) {
                cnt += nums[j];
                if (cnt == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
