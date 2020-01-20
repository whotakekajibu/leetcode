package dp;

public class Longest_Increasing_Subsequence_300 {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(helper(arr, arr.length - 1, true));
    }
//    public int lengthOfLIS(int[] nums) {
//
//    }

    //dp[i] must end with i
    //         dp[i-1] if arr[i] <= arr[i - 1]
    //dp[i] =
    //         dp[i-1]+1

    //LIS end with i
    static int helper(int[] arr, int cur, int after) {

        if (cur == arr.length) {
            return 0;
        }
        return 0;
    }

}
