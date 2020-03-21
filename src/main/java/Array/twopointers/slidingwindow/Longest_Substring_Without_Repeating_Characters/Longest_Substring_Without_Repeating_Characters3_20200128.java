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
public class Longest_Substring_Without_Repeating_Characters3_20200128 {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        int l = 0, r = 0, ans = 1;
        while (r < chars.length) {
            if (map.containsKey(chars[r])) {
                Integer preIdx = map.get(chars[r]);
                if (preIdx >= l) {
                    l = preIdx + 1;
                }
            }
            map.put(chars[r], r);
            ans = Math.max(r - l + 1, ans);
            r++;
        }
        return ans;
    }
}
