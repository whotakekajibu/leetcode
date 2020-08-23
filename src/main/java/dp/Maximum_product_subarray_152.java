package dp;

/**
 * @Description
 * @Date 2020/5/18 19:15
 **/
public class Maximum_product_subarray_152 {
    public static void main(String[] args) {
//        int[] arr = {2, 3, -2, 4};
//        int[] arr = {-2, 0, -1};
        int[] arr = {-1, -1};
        System.out.println(maxProductON(arr));
    }

    /**
     * [2,3,-2,4]
     * [-2,0,-1]
     * O(N^2) MLE（内存超出限制）
     *
     * @param arr
     * @return
     */
    public static int maxProduct(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][arr.length];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i < j) {
                    continue;
                } else if (i == j) {
                    dp[i][j] = arr[i];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 0 || arr[j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] * arr[i] * arr[j];
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * O(2N) --> O(N)
     *
     * @return
     */
    public static int maxProductON(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0] > 0 ? arr[0] : 1;
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = arr[i] * dp[i - 1][0];
            if (arr[i] > 0) {
                dp[i][1] = arr[i] * dp[i - 1][1];
            } else {
                dp[i][1] = 1;
            }
            int max = Math.max(dp[i][0], dp[i][1]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
