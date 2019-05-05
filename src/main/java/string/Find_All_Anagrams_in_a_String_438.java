package string;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams_in_a_String_438 {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int[] m = new int[26];
        int left = 0, right = 0, cnt = p.length(), n = s.length();
        for (char c : p.toCharArray()) ++m[c - 'a'];
        while (right < n) {
            int idx = s.charAt(right) - 'a';
            if (m[idx] >= 1) {
                --cnt;
            }
            m[idx]--;
            right++;
            if (cnt == 0) res.add(left);
            if (right - left == p.length()) {
                idx = s.charAt(left) - 'a';
                if (m[idx] >= 0) {
                    ++cnt;
                }
                m[idx]++;
                left++;
            }
        }
        return res;
    }
}
