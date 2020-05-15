package dp.Stone_Game_877;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/4/6 12:10
 **/
public class Stone_Game_stable_sort_877 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 5};
//        int[] arr = {7, 100, 2, 6};
//        System.out.println(stoneGame(arr));
        System.out.println(firstPickGains(arr, 0, arr.length - 1));
    }

    public static boolean stoneGame(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            for (int j = i; j < arr.length; j++) {
                if (i == j) {
                    dp[i][j] = arr[i];
                } else if (i + 1 == j) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                }
            }
        }
        for (int i = arr.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < arr.length; j++) {
                int pickLeft = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                int pickRight = arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }
        return 2 * dp[0][arr.length - 1] > sum;
    }

    //first picker
    public static int firstPickGains(int[] arr, int start, int end) {
        if (start > end) {
            return 0;
        }
        //由于第二个人也肯定是最优的选择，所以要取min
        //第二个人得取得区间是[start+1]
        int pickLeft = arr[start] + Math.min(firstPickGains(arr, start + 2, end), firstPickGains(arr, start + 1, end - 1));
        int pickRight = arr[end] + Math.min(firstPickGains(arr, start, end - 2), firstPickGains(arr, start + 1, end - 1));
        return Math.max(pickLeft, pickRight);
    }


}
