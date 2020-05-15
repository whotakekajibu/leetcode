package Array.Best_time_to_buy_and_sold_stocks_II_122;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * @Description
 * @Date 2020/4/4 23:38
 **/
public class Best_time_to_buy_and_sold_stocks_II_122 {


    public static void main(String[] args) throws IOException {
//        int[] arr = {7, 1, 5, 3, 6, 4};
//        int[] arr = {1, 6, 7};
//        int[] arr = {1, 8, 7};
//        int[] arr = {2, 2, 9, 7};
        int[] arr = new int[26004];
        Files.lines(new File("intput.txt").toPath()).forEach(s -> {
            String[] split = s.split(",");
            for (int i = 0; i < split.length; i++) {
                arr[i] = Integer.valueOf(split[i]);
            }
        });
        System.out.println(maxProfitDp(arr));
    }

    public void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int
                dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <
                dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void rotateEdge(int[][] m, int lx, int ly, int rx, int ry) {
        // times就是总的组数
        int times = ry - ly;
        int tmp = 0;
        // 一次循环就是一组占据调整
        for (int i = 0; i != times; i++) {
            tmp = m[lx][ly + i];
            m[lx][ly + i] = m[rx - i][ly];
            m[rx - i][ly] = m[rx][ry - i];
            m[rx][ry - i] = m[lx + i][ry];
            m[lx + i][ry] = tmp;
        }
    }

    //dp[i,j]=max(dp[i,k]+dp[k,j]) i<k<j
    public static int maxProfit(int[] prices) {
        int[][] map = new int[prices.length][prices.length];
        for (int[] ints : map) {
            Arrays.fill(ints, -1);
        }
        return helper(prices, 0, prices.length - 1, map);
    }

    //dp[i,j]=max(dp[i,k]+dp[k,j]) i<k<j
    public static int maxProfitDp(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (j < i) {
                    continue;
                } else if (j == i) {
                    dp[i][j] = 0;
                } else if (j - i == 1) {
                    int profit = arr[j] - arr[i];
                    dp[i][j] = profit > 0 ? profit : 0;
                }

            }
        }
        int cnt = 0;
        for (int i = arr.length - 3; i >= 0; i--) {
            System.out.println("complete  line: " + cnt++);
            for (int j = i + 2; j < arr.length; j++) {
                int curRes = 0;
                for (int k = i; k < j; k++) {
                    curRes = Math.max(Math.max(dp[i][k] + dp[k + 1][j], curRes), arr[j] - arr[i]);
                }
                dp[i][j] = curRes;
            }
        }
        return dp[0][arr.length - 1];
    }

    public static int helper(int[] arr, int start, int end, int[][] map) {
        if (map[start][end] != -1) {
            return map[start][end];
        }
        if (start >= end) {
            return 0;
        }
        if (end - start == 1) {
            int profit = arr[end] - arr[start];
            return profit > 0 ? profit : 0;
        }
        int max = 0;
        for (int i = start; i < end; i++) {
            int left = helper(arr, start, i, map);
            int right = helper(arr, i + 1, end, map);
            int beginAndLast = arr[end] - arr[start] > 0 ? arr[end] - arr[start] : 0;
            max = Math.max(Math.max(max, beginAndLast), left + right);
        }
        return map[start][end] = max;
    }
}
