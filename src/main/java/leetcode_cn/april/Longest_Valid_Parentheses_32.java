package leetcode_cn.april;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Date 2020/4/23 21:57
 **/
public class Longest_Valid_Parentheses_32 {
    public static void main(String[] args) {
//        String s = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
        String s = "(())(())";
        System.out.println(longestValidParenthesesDp(s));
        longestValidParentheses(s);
//        System.out.println(bruteForce(s));
    /*    List<Character> characters = Arrays.asList('(',')');
        List<String> strings = Utils.generateStringsSpecifyCharacters(characters,8,100000);
        for (String string : strings) {
            if (bruteForce(string) != longestValidParentheses(string)){
                System.out.println(string);
                break;
            }
        }*/
    }

    /**
     * dp[i][j]
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        return helper(s.toCharArray(), 0, s.length() - 1);
    }


    public static int longestValidParenthesesDp(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            if (chars[i] == '(' && chars[i + 1] == ')') {
                dp[i][i + 1] = 2;
            }
        }
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                if (chars[i] == '(' && chars[j] == ')') {
                    if (dp[i + 1][j - 1] == j - i - 1) {
                        dp[i][j] = j - i + 1;
                        continue;
                    }
                    if (dp[i][i + 1] + dp[i + 2][j] == j - i + 1 || dp[i][j - 2] + dp[j - 1][j] == j - i + 1) {
                        dp[i][j] = j - i + 1;
                        continue;
                    }
                }
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }

    public static int bruteForce(String s) {
        int ans = 0;
        Set<String> sets = new HashSet<>();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (valid(substring)) {
                    ans = Math.max(ans, i - j);
                }
            }
        }
        return ans;
    }

    public static boolean valid(String s) {
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                idx++;
            } else if (c == ')') {
                idx--;
            }
            if (idx < 0) {
                return false;
            }
        }
        return idx == 0;
    }

    public static int helper(char[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (i + 1 == j) {
            if (arr[i] == '(' && arr[j] == ')') {
                return 2;
            }
            return 0;
        }
        int il = 0, ir = 0;
        if (arr[i] == '(' && arr[j] == ')') {
            int inner = helper(arr, i + 1, j - 1);
            if (inner == j - i - 1) {
                return inner + 2;
            }
            il = helper(arr, i, i + 1);
            ir = helper(arr, i + 2, j);
            if (il + ir == j - i + 1) {
                return j - i + 1;
            }
            il = helper(arr, i, j - 2);
            ir = helper(arr, j - 1, j);
            if (il + ir == j - i + 1) {
                return j - i + 1;
            }
        }
        int left = helper(arr, i + 1, j);
        int right = helper(arr, i, j - 1);
        return max(il, ir, left, right);
    }

    public static int max(int... arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

}
