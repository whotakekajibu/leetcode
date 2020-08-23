package classic;


import Utils.Utils;

/**
 * @Description input an inorder  number array，find the longest continuous sequence length  O(N)
 * eg: input 54,55,300,12,56 output 3(54,55,56)
 * eg: 100,4,200,1,3,2 output 4(1,2,3,4)
 * @Date 2020/1/3 18:33
 **/
public class LongestContinueSequence {

    /**
     * dp[i][j] = [0-i][0-j] longestCommonSubsequence
     *
     * @return
     */
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

    public static void main(String[] args) {
        String text1 = "ace";
        String text2 = "abcde";
        System.out.println(longestCommonSubsequenceRecur(text1, text2));
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequenceRecur(String text1, String text2) {
        return helper(text1, 0, text2, 0);
    }

    public static int helper(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + helper(s1, i + 1, s2, j + 1);
        }
        return Math.max(helper(s1, i + 1, s2, j), helper(s1, i, s2, j + 1));
    }

}
