package Array.twopointers.slidingwindow.Longest_Substring_Without_Repeating_Characters;

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
public class Longest_Substring_Without_Repeating_Characters3_20200507 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        int l = 0, r = 0, ans = 0;
        while (r < s.length()) {
            char cur = s.charAt(r++);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.get(cur) != null && map.get(cur) > 1) {
                char d = s.charAt(l++);
                map.put(d, map.get(d) - 1);
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
