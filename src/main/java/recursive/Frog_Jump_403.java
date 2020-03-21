package recursive;

public class Frog_Jump_403 {
    public static void main(String[] args) {
//        int[] arr = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] arr = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(canCross(arr));
    }

    public static boolean canCross(int[] arr) {
//        return helper(stones, 1, 1);
        if (arr == null || arr.length == 0) return false;
        if (arr.length == 1) return true;
        boolean[] reach = new boolean[arr.length];
        int[] k = new int[arr[arr.length - 1]];
        reach[0] = true;
        if ()
        //dp[i][j]
//        int[][] dp = new int[arr.length][arr[arr.length - 1]];

    }

    private static boolean helper(int[] arr, int idx, int k) {
        if (idx >= arr.length - 1) {
            return true;
        }
        boolean less = false, more = false, res = false;
        int curIdx = idx + 1;
        while (!less && curIdx < arr.length) {
            if (arr[idx] + k - 1 != arr[curIdx]) {
                less = true;
            }
            curIdx++;
        }
        if (less) {
            res = helper(arr, curIdx - 1, k - 2) || helper(arr, curIdx - 1, k);
        }
        curIdx = idx + 1;
        while (!more && curIdx < arr.length) {
            if (arr[idx] + k + 1 != arr[curIdx]) {
                more = true;
            }
            curIdx++;
        }
        if (more) {
            res = helper(arr, curIdx - 1, k) || helper(arr, curIdx - 1, k + 2);
        }
        return res;
    }
}
