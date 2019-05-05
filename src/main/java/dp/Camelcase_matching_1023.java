package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Camelcase_matching_1023 {
    static boolean match(String w, String p) {
        boolean[][] dp = new boolean[w.length() + 1][p.length() + 1];
        dp[w.length()][p.length()] = true;
        int idx = 0;
        for (int i = 0; i < w.length(); i++) {
            if ('A' <= w.charAt(i) && w.charAt(i) <= 'Z') {
                break;
            }
            idx++;
        }
        if (idx == w.length()) {
            for (int i = 0; i < w.length(); i++) {
                dp[i][p.length()] = true;
            }
        }
        for (int i = w.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (w.charAt(i) == p.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    if ('A' <= w.charAt(i) && w.charAt(i) <= 'Z') {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }

        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String[] ls = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        System.out.println(camelMatch(ls, "FB"));
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
//        Stack<Character>
        List<Boolean> res = new ArrayList<>();
        for (String s : queries) {
            int[][] memo = new int[s.length() + 1][pattern.length() + 1];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }
            res.add(match(s, 0, pattern, 0, memo));
        }
        return res;
    }

    static boolean match(String w, int i, String p, int j, int[][] memo) {
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        if (i == w.length() && j == p.length()) {
            memo[i][j] = 1;
            return true;
        } else if (j == p.length()) {
            while (i < w.length()) {
                if ('A' <= w.charAt(i) && w.charAt(i) <= 'Z') {
                    memo[i][j] = 0;
                    return false;
                }
                i++;
            }
            memo[i][j] = 1;
            return true;
        } else if (i == w.length()) {
            memo[i][j] = 0;
            return false;
        } else {
            if (w.charAt(i) == p.charAt(j)) {
                boolean res = match(w, i + 1, p, j + 1, memo);
                if (res) {
                    memo[i][j] = 1;
                } else {
                    memo[i][j] = 0;
                }
                return res;
            } else {
                if ('A' <= w.charAt(i) && w.charAt(i) <= 'Z') {
                    memo[i][j] = 0;
                    return false;
                }
                boolean res = match(w, i + 1, p, j, memo);
                if (res) {
                    memo[i][j] = 1;
                } else {
                    memo[i][j] = 0;
                }
                return res;
            }
        }
    }
}
