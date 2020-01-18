package recursive.backtracking.wordBreakII;

import java.util.*;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2019/12/2 23:23
 **/
public class WordBreakII_140_20191202 {

    /**
     * catsanddog
     *
     * @param
     * @param \["cat", "cats", "and", "sand", "dog"]
     * @return
     */
    public static void main(String[] args) {
//        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s = "catsanddog";
//        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa");
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> res = wordBreak(s, wordDict);
        for (String re : res) {
            System.out.println(re);
        }
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
        List<String> res = new ArrayList<>();
        int[][] map = new int[2 * s.length()][2 * s.length()];
        for (int[] ints : map) {
            Arrays.fill(ints, -1);
        }
        helper(res, new StringBuilder(s), 0, 1, new HashSet<>(wordDict), map);
        return res;
    }

    public static void helper(List<String> res, StringBuilder sb, int start, int end, Set<String> wordDict, int[][] map) {
        System.out.println("计算start= " + start + " end= " + end + "substring= " + sb.substring(start, end));
        if (end >= sb.length()) {
            String sub = sb.substring(start, sb.length());
            if (wordDict.contains(sub)) {
                res.add(sb.toString());
            }
            return;
        }
        if (wordDict.contains(sb.substring(start, end))) {
            sb.insert(end, " ");
            helper(res, sb, end + 1, end + 2, wordDict, map);
            sb.deleteCharAt(end);
        }
        helper(res, sb, start, end + 1, wordDict, map);
    }
}
