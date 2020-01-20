package dp;

public class Maximum_Subarray_53 {


    public static void main(String[] args) {
//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr = {8, -19, 5, -4, 20};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray_dp(arr));
        System.out.println(maxSubArray_divide_and_conquer(arr));
    }


    ////////////////////////////////////////////////////////////////////

    /**
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        ans = Integer.MIN_VALUE;
        helper(nums, nums.length - 1);
        return ans;
    }

    static int ans;

    public static int helper(int[] arr, int idx) {
        if (idx < 0) {
            return 0;
        }
        int pre = helper(arr, idx - 1);
        if (pre < 0) {
            ans = Math.max(ans, arr[idx]);
            return arr[idx];
        }
        ans = Math.max(ans, pre + arr[idx]);
        return pre + arr[idx];
    }
    ////////////////////////////////////////////////////////////////////


    ////////////////////////////////dp////////////////////////////////////

    /**
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * @param nums
     * @return
     */
    public static int maxSubArray_dp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    ////////////////////////////////dp////////////////////////////////////


    ////////////////////////////////divide and conquer////////////////////////////////////
    public static int maxSubArray_divide_and_conquer(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    static int helper(int[] arr, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        if (left == right) {
            return arr[left];
        }
        int mid = (right + left) / 2;
        int leftSum = helper(arr, left, mid - 1);
        int rightSum = helper(arr, mid + 1, right);
        int continueLeft = maxSumFromTo(arr, mid - 1, left, -1);
        int continueRight = maxSumFromTo(arr, mid + 1, right, 1);
        int midSum = max(continueLeft, continueRight + continueLeft, continueRight, Integer.MIN_VALUE) + arr[mid];
        return max(leftSum, rightSum, midSum, arr[mid]);
    }

    public static int max(int a, int b, int c, int d) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        if (d > a) {
            a = d;
        }
        return a;
    }

    public static int maxSumFromTo(int[] arr, int from, int to, int interval) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        if (interval > 0) {
            if (from > to) {
                return cur;
            }
            for (int i = from; i <= to; i++) {
                cur += arr[i];
                res = Math.max(cur, res);
            }
        } else {
            if (to > from) {
                return cur;
            }
            for (int i = from; i >= to; i--) {
                cur += arr[i];
                res = Math.max(cur, res);
            }
        }
        return res;
    }


    ////////////////////////////////divide and conquer////////////////////////////////////
}
