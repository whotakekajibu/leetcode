package leetcode_cn.may;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/5/9 9:28
 **/
public class Jump_game_ii_45 {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 1, 1, 4};
        int[] arr = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        System.out.println(jump(arr));
    }

    public static int jump(int[] arr) {
        int[] dp = new int[arr.length];
        dp[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (i + arr[i] >= arr.length - 1) {
                dp[i] = 1;
            } else {
                if (arr[i] == 0) {
                    dp[i] = Integer.MAX_VALUE;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int j = i + 1; j <= i + arr[i]; j++) {
                    min = Math.min(min, dp[j]);
                }
                if (min == Integer.MAX_VALUE) {
                    dp[i] = Integer.MAX_VALUE;
                } else {
                    dp[i] = min + 1;
                }

            }
        }
        return dp[0];
    }
}
