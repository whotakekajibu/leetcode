package dp;

import Utils.Utils;

import java.util.Arrays;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/1/10 14:51
 **/
public class Minimum_Insertion_Steps_to_Make_a_String_Palindrome_1312 {
    public static void main(String[] args) {
        /**
         * "zjveiiwvc"
         * "dyyuyabzkqaybcspq"
         * "leetcode"
         */
//        System.out.println(minInsertions_memoization("dyyuyabzkqaybcspq"));
        System.out.println(minInsertions_Dp("dyyuyabzkqaybcspq"));
//        System.out.println(minInsertions_memoization("abc"));
//        System.out.println(minInsertions_Dp("abc"));
    }


    ///////////////////////////////////////////memoization/////////////////////////////////////////////////////
    public static int minInsertions_memoization(String s) {
        int[][] map = new int[s.length()][s.length()];
        for (int[] ints : map) {
            Arrays.fill(ints, -1);
        }
        return helper(s, 0, s.length() - 1, map);
    }


    public static int helper(String sb, int l, int r, int[][] map) {
        if (map[l][r] != -1) {
            return map[l][r];
        }
        if (l == r) {
            return 0;
        }
        if (r - l == 1) {
            if (sb.charAt(l) == sb.charAt(r)) {
                return 0;
            }
            return 1;
        }
        if (sb.charAt(l) == sb.charAt(r)) {
            return map[l][r] = helper(sb, l + 1, r - 1, map);
        } else {
            int leftTowards = helper(sb, l + 1, r, map);
            int rightBackwards = helper(sb, l, r - 1, map);
            return map[l][r] = Math.min(leftTowards, rightBackwards) + 1;
        }
    }
    ////////////////////////////////////////////memoization////////////////////////////////////////////////////


    ////////////////////////////////////////////dp////////////////////////////////////////////////////
    public static int minInsertions_Dp(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j < i) {
                    continue;
                }
                if (i == j) {
                    dp[i][j] = 0;
                } else if (j - i == 1) {
                    if (s.charAt(j) == s.charAt(i)) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return dp[0][len - 1];
    }

    ////////////////////////////////////////////dp////////////////////////////////////////////////////


}
