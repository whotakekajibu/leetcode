package dp.wordbreak;

import java.util.*;

/**
 * @Description
 * @Date 2020/6/28 19:15
 **/
public class Word_Break_139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, dict));
    }

    /**
     * T   dp[i-1] && contains(A[i:]);
     * dp[i] =
     * F
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> dict = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String right = s.substring(j, i);
                if (dp[j] && dict.contains(right)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
