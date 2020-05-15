package Array.twopointers.slidingwindow.Find_All_Anagrams_in_a_String438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_All_Anagrams_in_a_String438_2020_05_07 {
    public static void main(String[] args) {
        String a = "cbaebabacd", b = "abc";
        System.out.println(findAnagrams(a, b));
    }

    //wrong
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> template = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        for (char c : p.toCharArray()) {
            template.put(c, template.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, valid = 0;
        while (r < s.length()) {
            char cur = s.charAt(r);
            r++;
            if (template.containsKey(cur)) {
                windows.put(cur, windows.getOrDefault(cur, 0) + 1);
                if (windows.get(cur).equals(template.get(cur))) {
                    valid++;
                }
            }
            while (r - l >= p.length()) {
                if (valid == template.size()) {
                    res.add(l);
                }
                char d = s.charAt(l);
                l++;
                if (template.containsKey(d)) {
                    if (windows.get(d).equals(template.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        return res;
    }

}
