package Array.twopointers.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_All_Anagrams_in_a_String438 {
    public static void main(String[] args) {
        String a = "cbaebabacd", b = "abc";
        System.out.println(findAnagrams(a, b));
    }

    //wrong
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        for (char c : cp)
            map.put(c, map.getOrDefault(c, 0) + 1);
        int l = 0, r = -1, cnt = map.size();
        while (l < s.length() - p.length() && r + 1 < s.length()) {
            char c = cs[++r];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    cnt--;
                }
            }
            while (cnt == 0) {
                if (r - l + 1 == p.length()) {
                    res.add(l);
                }
                l++;
                char tmp = cs[l];
                if (map.containsKey(tmp)) {
                    map.put(c, map.get(c) + 1);
                    cnt++;
                }
            }
        }
        return res;
    }

}
