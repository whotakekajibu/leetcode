package greedy;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/4/17 16:46
 **/
public class Jump_Game_55 {
    /**
     * 2,3,1,1,4
     *
     * @return
     */
    public static void main(String[] args) {
//        int[] arr = {2, 3, 1, 1, 4};
        int[] arr = {3, 2, 1, 0, 4};
//        int[] arr = {0};
//        int[] arr = {2, 0};
//        int[] arr = {4, 0, 4, 2, 2, 0, 1, 3, 3, 0, 3};
//        int[] arr = {2, 0, 1, 3, 3, 0, 3};
//        System.out.println(canJump(arr));
//        System.out.println(canJumpDpO1Space(arr));
        System.out.println(canJumpDpO1Space(arr));
    }

    static boolean helper(int[] arr, int idx) {
        if (idx >= arr.length - 1) {
            return true;
        }
        boolean ans = true;
        for (int i = arr[idx]; i >= 1; i--) {
            if (idx + i >= arr.length - 1) {
                return true;
            }
            if (idx + i + arr[idx + i] >= arr.length - 1) {
                return true;
            }
            if (helper(arr, idx + i)) {
                ans = true;
                break;
            }
        }
        return ans;
    }

    /**
     * greedy
     *
     * @param arr
     * @return
     */
    public static boolean canJumpDpO1Space(int[] arr) {
        int maxReachable = 0;
        for (int idx = 0; idx < arr.length; idx++) {
            if (idx > maxReachable) {
                return false;
            }
            if (idx + arr[idx] > maxReachable) {
                maxReachable = idx + arr[idx];
            }
            if (maxReachable >= arr.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean canJumpONSpace(int[] arr) {
        boolean[] dp = new boolean[arr.length];
        dp[arr.length - 1] = true;
        for (int idx = arr.length - 2; idx >= 0; idx--) {
            for (int i = arr[idx]; i >= 1; i--) {
                if (idx + i >= arr.length - 1 || idx + i + arr[idx + i] >= arr.length - 1 || dp[idx + i]) {
                    dp[idx] = true;
                    break;
                }
            }
            System.out.println("idx : " + idx + " " + dp[idx]);
        }
        return dp[0];
    }


}
