package Array.twopointers.slidingwindow.Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 类的描述
 *
 * @createTime 2019-12-14 22:49:11
 */
public class Longest_Substring_Without_Repeating_Characters3_20191214 {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, ans = 1;
        while (r < s.length()) {
            Integer idx = map.get(s.charAt(r));
            if (idx != null) {
                if (idx < l){
                    ans = Math.max(r - l, ans);
                }else {
                    ans = Math.max(r - l + 1,ans);
                }
                l = idx + 1;
            }
            map.put(s.charAt(r), r);
            r++;
        }
        return ans;
    }
}
