package dp.longest;

public class Longest_Valid_Parentheses_32 {
    public static void main(String[] args) {
//        String s = "((()";
//        String s = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
        String s = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
//        System.out.println(longestValidParenthesesWith1Demension(s));
        System.out.println(longestValidParenthesesWith2Demension(s));
    }

    public static int longestValidParenthesesWith1Demension(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }
        int[] dp = new int[len];
        dp[len - 1] = 0;
        if (s.charAt(len - 2) == '(' && s.charAt(len - 1) == ')') {
            dp[len - 2] = 2;
        }
        int res = dp[len - 2];
        for (int i = len - 3; i >= 0; i--) {
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                dp[i] = 2 + dp[i + 2];
            } else if (s.charAt(i) == '(' && s.charAt(i + 1) == '(' && i + dp[i + 1] + 1 < len && s.charAt(i + dp[i + 1] + 1) == ')') {
                dp[i] = 2 + dp[i + 1];
                if (i + dp[i + 1] + 2 < len) {
                    dp[i] += dp[i + dp[i + 1] + 2];
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int longestValidParenthesesWith2Demension(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
//        int  w = len;
//        for (int i = 0; i < len; i++) {
//            dp[i] = new int[w--];
//            if (w ==0){
//                break;
//            }
//        }
        for (int i = 0; i < len - 1; i++) {
            int j = i + 1;
            if (s.charAt(i) == '(' && s.charAt(j) == ')') {
                dp[i][j] = 2;
            }
        }
        for (int i = len - 3; i >= 0; i--) {
            dp[i][i] = 0;
            for (int j = i + 2; j < len; j++) {
                int res = 0;
                if (s.charAt(i) == '(' && s.charAt(j) == ')') {
                    int cnt = 0;
                    for (int cur = i; cur < j; cur++) {
                        if (s.charAt(cur) == '(') {
                            cnt++;
                        }
                        if (s.charAt(cur) == ')') {
                            cnt--;
                        }
                        if (cnt == 0) {
                            int left = dp[i][cur], right = dp[cur + 1][j];
                            if (left + right == j - i + 1) {
                                dp[i][j] = left + right;
                            } else {
                                res = Math.max(left, right);
                            }
                            break;
                        }
                    }
                    if (dp[i][j] != 0) {
                        continue;
                    }
                    if (res == 0) {
                        int outerType = dp[i + 1][j - 1];
                        if (outerType == j - i - 1) {
                            dp[i][j] = 2 + outerType;
                            continue;
                        } else {
                            res = outerType;
                        }
                    }
                }
                int left = dp[i + 1][j];
                if (left == j - i) {
                    dp[i][j] = left;
                    continue;
                }
                int right = dp[i][j - 1];
                if (right == j - i) {
                    dp[i][j] = right;
                    continue;
                }
                dp[i][j] = Math.max(res, Math.max(left, right));
            }
        }
        return dp[0][len - 1];
    }
}
