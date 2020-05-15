package recursive.backtracking.wordBreakII;

import java.util.*;

/**
 * @Description
 * @Date 2019/12/2 23:23
 **/
public class WordBreakII_140_20191212_nonbacktrack {

    /**
     * catsanddog
     *
     * @param
     * @param \["cat", "cats", "and", "sand", "dog"]
     * @return
     */
    public static void main(String[] args) {
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s = "a";
//        String s = "catsanddog";
//        String s = "catsand";
//        String s = "pineapplepenapple";
//        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa");
        List<String> wordDict = Arrays.asList("a");
//        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
//        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> res = wordBreak(s, wordDict);
        for (String re : res) {
            System.out.println(re);
        }
        System.out.println("abc".substring(0, 0));
    }

    /**
     * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
     * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> sets = new HashSet<>(wordDict);
        List<String> res = helper(s, sets);
        return res;
    }

    static Map<String, List<String>> map = new HashMap<>();

    public static List<String> helper(String sub, Set<String> sets) {
        if (map.containsKey(sub)) {
            return map.get(sub);
        }
        List<String> res = new ArrayList<>();
        if (sub.length() == 0) {
            res.add("");
            return res;
        }
        for (int i = 0; i < sub.length(); i++) {
            String left = sub.substring(0, i);
            String right = sub.substring(i);
            if (sets.contains(right)) {
                List<String> leftRes = helper(left, sets);
                if (leftRes.isEmpty()) {
                    continue;
                }
                for (String leftRe : leftRes) {
                    if (leftRe.length() == 0) {
                        res.add(right);
                    } else {
                        res.add(leftRe + " " + right);
                    }
                }
            }
        }
        map.put(sub, res);
        return res;
    }
}
