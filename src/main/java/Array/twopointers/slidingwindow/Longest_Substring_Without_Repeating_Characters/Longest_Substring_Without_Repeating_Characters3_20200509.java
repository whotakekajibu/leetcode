package Array.twopointers.slidingwindow.Longest_Substring_Without_Repeating_Characters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 类的描述
 * pwwkew
 * abba
 * au
 * tmmzuxt
 *
 * @createTime 2019-12-14 22:49:11
 */
public class Longest_Substring_Without_Repeating_Characters3_20200509 {
    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "pwwkew";
//        String s = "au";
//        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println((int) 'a');
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = 0, r = 0, ans = 1;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        while (r < s.length()) {
            char cur = s.charAt(r++);
            if (map[cur] != -1) {
                int preIdx = map[cur];
                if (preIdx >= l) {
                    l = preIdx + 1;
                }
            }
            map[cur] = r - 1;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
