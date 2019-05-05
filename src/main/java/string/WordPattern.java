package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("ab", "ab"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char key = pattern.charAt(i);
            String value = key + "_" + strs[i];
            if (map.containsKey(key)) {
                if (!map.get(key).equals(value)) {
                    return false;
                }
            } else {
                map.put(key, value);
            }
        }
        return true;
    }
}
