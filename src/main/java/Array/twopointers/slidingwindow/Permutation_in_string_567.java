package Array.twopointers.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2020/5/7 15:42
 **/
public class Permutation_in_string_567 {
    public static void main(String[] args) {
        String s1 = "hello";
//        String s2 = "eidbaooo";
        String s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> template = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            template.put(c, template.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, valid = 0;
        while (r < s2.length()) {
            char cur = s2.charAt(r);
            r++;
            if (template.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(template.get(cur))) {
                    valid++;
                }
            } else {
                window.clear();
                valid = 0;
            }
            while (r - l >= s1.length()) {
                if (valid == template.size()) {
                    return true;
                }
                char d = s2.charAt(l);
                l++;
                if (template.containsKey(d)) {
                    if (template.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
