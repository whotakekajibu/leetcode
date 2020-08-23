package leetcode_cn.may;

/**
 * @Description
 * @Date 2020/5/8 20:28
 **/
public class Maximal_square_221 {
    public static void main(String[] args) {
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'0', '0', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}};
  /*      char[][] matrix = {
                {'1', '0', '1'},
                {'1', '1', '1'},
                {'1', '1', '1'},
                {'0', '1', '1'}};*/
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '0') {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
                ans = 1;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '0') {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
                ans = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int min = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                    if (min != 0) {
                        double x = Math.sqrt(min);
                        dp[i][j] = (int) Math.pow(x + 1, 2);
                    } else {
                        dp[i][j] = 1;
                    }
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans;
    }

    static int min(int... nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (ans > nums[i]) {
                ans = nums[i];
            }
        }
        return ans;
    }
}
