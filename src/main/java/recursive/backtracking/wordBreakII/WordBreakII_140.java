package recursive.backtracking.wordBreakII;

import java.util.*;

public class WordBreakII_140 {

    public static void main(String[] args) {
        WordBreakII_140 wb = new WordBreakII_140();
        List<String> dic = Arrays.asList("cats", "dog", "sand", "and", "cat");
        String s = "catsandog";
//        List<String> dic = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
//        String s = "pineapplepenapple";
        wb.wordBreak_AC(s, dic).stream().forEach(System.out::println);
    }


    /////////////////////////////TLE///////////////////////////////
    public List<String> wordBreak_TLE(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        helper(s, wordDict, res, new ArrayList<>(), 0);
        return res;
    }

    void helper(String s, List<String> dic, List<String> res, List<String> cur, int idx) {
        int len = s.length();
        if (idx == len) {
            StringBuilder sb = new StringBuilder();
            for (String e : cur) {
                sb.append(e);
                sb.append(" ");
            }
            s = sb.toString();
            s = s.substring(0, s.length() - 1);
            res.add(s);
            return;
        }
        for (int i = idx; i <= len; i++) {
            String left = s.substring(idx, i);
            if (dic.contains(left)) {
                cur.add(left);
                helper(s, dic, res, cur, i);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /////////////////////////////AC///////////////////////////////

    public List<String> wordBreak_AC(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    Map<Integer, List<String>> map = new HashMap<>();

    List<String> helper(String s, List<String> dict, int idx) {
        if (map.get(idx) != null) {
            return map.get(idx);
        }
        List<String> ans = new LinkedList<>();
        if (idx == s.length()) {
            return ans;
        }
        for (int i = idx; i <= s.length(); i++) {
            String left = s.substring(idx, i);
            if (dict.contains(left)) {
                List<String> after = helper(s, dict, i);
                if (!after.isEmpty()) {
                    for (String s1 : after) {
                        ans.add(left + " " + s1);
                    }
                }else if (i == s.length()){
                    ans.add(left);
                }
            }
        }
        map.put(idx, ans);
        return ans;
    }
}
