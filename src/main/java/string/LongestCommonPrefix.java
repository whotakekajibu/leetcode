package string;

import java.util.Map;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Map<Integer,Integer> m = null;
        return helper(strs, 0, "");
    }

    static String helper(String[] strs, int idx, String res) {
        if (idx + 1 > strs[0].length())
            return res;
        char c = strs[0].charAt(idx);
        for (int i = 1; i < strs.length; i++) {
            if (idx + 1 > strs[i].length() || strs[i].charAt(idx) != c) {
                return res;
            }
        }
        return helper(strs, idx + 1, res + c);
    }
}
