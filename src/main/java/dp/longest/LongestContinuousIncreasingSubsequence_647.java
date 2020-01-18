package dp.longest;

/**
 * resolved
 */
public class LongestContinuousIncreasingSubsequence_647 {
    public static void main(String[] args) {
        // int[] arr = { 1, 3, 5, 4, 7 };
        int[] arr = {1, 4, 5, 4, 2, 1, 4};
        System.out.println(findLengthOfLCIS(arr));
    }

    public static int findLengthOfLCIS(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int l = 0, r = 0;
        int res = 1;
        while (r < arr.length - 1) {
            if (arr[r] < arr[r + 1]) {
                r++;
                res = Math.max(res, r - l + 1);
            } else {
                r++;
                l = r;
            }
        }
        return res;
    }
}
