package Array.twopointers.slidingwindow;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Date 2020/4/26 15:40
 **/
public class Minimum_Window_Substring_76 {

    /**
     * 示例：
     * <p>
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(minWindow("adobecodebanc", "abc"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> template = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : t.toCharArray()) {
            template.put(c, template.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, cnt = 0, startIdx = 0, len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char cur = s.charAt(r);
            r++;
            if (template.containsKey(cur)) {
                windows.put(cur, windows.getOrDefault(cur, 0) + 1);
                if (windows.get(cur).equals(template.get(cur))) {
                    cnt++;
                }
            }
            while (cnt == template.size()) {
                if (r - l < len) {
                    len = r - l;
                    startIdx = l;
                }
                char d = s.charAt(l);
                l++;
                if (template.containsKey(d)) {
                    if (windows.get(d).equals(template.get(d))) {
                        cnt--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIdx, startIdx + len);
    }
}
