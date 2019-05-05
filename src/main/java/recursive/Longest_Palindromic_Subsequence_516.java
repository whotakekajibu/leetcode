package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Longest_Palindromic_Subsequence_516 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("forgeeksskeegfor"));
    }

    public static int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return helper(s.toCharArray(), 0, s.length() - 1, memo);
    }

    static int helper(char[] chars, int i, int j, int[][] memo) {
        if (memo[i][j] != -1) return memo[i][j];
        if (i > j) return 0;
        if (i == j) return 1;
        int res;
        if (chars[i] == chars[j]) {
            res = 2 + helper(chars, i + 1, j - 1, memo);
        } else {
            res = Math.max(helper(chars, i + 1, j, memo), helper(chars, i, j - 1, memo));
        }
        return memo[i][j] = res;
    }
}
