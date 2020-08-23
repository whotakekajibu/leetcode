package dp;

import Utils.Utils;

/**
 * @Description
 * @Date 2020/5/20 0:02
 **/
public class Shortest_Common_Supersequence_1092 {
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        String common = longestCommonSubsequence(str1, str2);
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, k = 0;
        while (i < common.length() || j < str1.length() || k < str2.length()) {
            char c = '0';
            if (i < common.length()) {
                c = common.charAt(i++);
            }
            while (j < str1.length() && c != str1.charAt(j)) {
                sb.append(str1.charAt(j++));
            }
            while (k < str2.length() && c != str2.charAt(k)) {
                sb.append(str2.charAt(k++));
            }
            j++;
            k++;
            if (c != '0') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        Utils.printTwoDimensionalArray(dp);
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++;
                j++;
            } else {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return sb.toString();
    }
}
