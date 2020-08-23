package leetcode_cn.may;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description
 * @Date 2020/5/21 10:26
 **/
public class Longest_Palindromic_Substring_05_20200521 {
    public static void main(String[] args) {
/*        String s = "abababa";
        System.out.println(longestPalindrome(s));*/
        heap();
    }


    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

    public static void heap() {
        List<Integer> integers =
                IntStream.range(1, 10)                      // <-- creates a stream of ints
                        .boxed()                                // <-- converts them to Integers
                        .collect(Collectors.toList());          // <-- collects the values to a list

    }



    public static int maxPower(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int pre = 1;
        int ans = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                pre = pre + 1;
                ans = Math.max(ans, pre);
            } else {
                pre = 1;
            }
        }
        return ans;
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int[] dp = new int[s.length()];
        int[] cdp = new int[s.length()];
        cdp[s.length() - 1] = 1;
        dp[s.length() - 1] = 1;
        int start = s.length() - 1, len = 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (i + dp[i + 1] + 1 < s.length() && s.charAt(i) == s.charAt(i + dp[i + 1] + 1)) {
                dp[i] = dp[i + 1] + 2;
            } else if (s.charAt(i) == s.charAt(i + 1)) {
                cdp[i] = cdp[i + 1] + 1;
                dp[i] = cdp[i];
            } else {
                if (i + 2 < s.length() && s.charAt(i) == s.charAt(i + 2)) {
                    dp[i] = 3;
                } else {
                    dp[i] = 1;
                }
                cdp[i] = 1;
            }
            if (dp[i] > len) {
                start = i;
                len = dp[i];
            }
        }
        return s.substring(start, start + len);
    }
}
