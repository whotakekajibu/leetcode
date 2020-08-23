package leetcode_cn.july;

import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Date 2020/7/9 11:50
 **/
public class Re_Space_LCCI_13 {

    /**
     * ["looked","just","like","her","brother"]
     * "jesslookedjustliketimherbrother"
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public static int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        Set<String> dict = new HashSet<>();
        for (String s : dictionary) {
            dict.add(s);
        }
        return helper(dict, 0, sentence);
    }

    public static int helper(Set<String> dict, int idx, String sentence) {
        if (idx == sentence.length()) {
            return 0;
        }
        int ans = -1;
        for (int i = idx; i < sentence.length(); i++) {
            int cur = -1;
            String left = sentence.substring(idx, i);
            String right = sentence.substring(i, sentence.length());
            if (dict.contains(left)) {
                cur = helper(dict, i + 1, sentence);
            } else {
                cur += left.length() + helper(dict, i + 1, sentence);
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
/* String[] dict = {"looked", "just", "like", "her", "brother"};
        String sentence = "jesslookedjustliketimherbrother";*/
//        System.out.println(respace(dict, sentence));

        Set<String> sets = Sets.newHashSet("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        String sentence = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(wordBreak(sentence, sets));
    }

    static Map<String, Boolean> map = new HashMap<>();

    public static boolean wordBreak(String str, Set<String> set) {
        Boolean flag = map.get(str);
        if (flag != null && flag) {
            return true;
        }
        if (set.contains(str)) {
            map.put(str, true);
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            if (set.contains(right) && wordBreak(left, set)) {
                map.put(str, true);
                return true;
            }
        }
        map.put(str, false);
        return false;
    }
}
