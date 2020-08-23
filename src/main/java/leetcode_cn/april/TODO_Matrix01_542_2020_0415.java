package leetcode_cn.april;

import Utils.Utils;

import java.util.Arrays;

/**
 * @Description
 * @Date 2020/4/15 22:18
 **/
public class TODO_Matrix01_542_2020_0415 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};
        Utils.printTwoDimensionalArray(updateMatrix(matrix));
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int[] an : ans) {
            Arrays.fill(an, -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dfs(matrix, ans, i, j);
                    i = matrix.length;
                    break;
                }
            }
        }
        return ans;
    }

    public static void dfs(int[][] matrix, int[][] ans, int x, int y) {
        if (x < 0 || x >= ans.length || y < 0 || y >= ans[0].length && ans[x][y] != -1) {
            return;
        }
        if (matrix[x][y] == 0) {
            ans[x][y] = 0;
        }
        int plural = ans[x][y];
        if (x - 1 >= 0 && ans[x - 1][y] == -1 && matrix[x - 1][y] == 1) {
            ans[x - 1][y] = plural + 1;
            dfs(matrix, ans, x - 1, y);
        }
        if (x + 1 < ans.length && ans[x + 1][y] == -1 && matrix[x + 1][y] == 1) {
            ans[x + 1][y] = plural + 1;
            dfs(matrix, ans, x + 1, y);
        }
        if (y - 1 >= 0 && ans[x][y - 1] == -1 && matrix[x][y - 1] == 1) {
            ans[x][y - 1] = plural + 1;
            dfs(matrix, ans, x, y - 1);
        }
        if (y + 1 < ans[0].length && ans[x][y + 1] == -1 && matrix[x][y + 1] == 1) {
            ans[x][y + 1] = plural + 1;
            dfs(matrix, ans, x, y + 1);
        }




    }

    static int min(int... nums) {
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            if (res > num) {
                res = num;
            }
        }
        return res;
    }
}
