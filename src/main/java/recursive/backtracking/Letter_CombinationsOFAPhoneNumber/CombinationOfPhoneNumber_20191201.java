package recursive.backtracking.Letter_CombinationsOFAPhoneNumber;

import java.util.*;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2019/12/1 12:46
 **/
public class CombinationOfPhoneNumber_20191201 {
    static Map<Character, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        List<String> res = new ArrayList<>();
        helper(res, digits.toCharArray(), 0, new StringBuilder());
        return res;
    }

    static void helper(List<String> res, char[] str, int idx, StringBuilder sb) {
        if (idx == str.length) {
            res.add(sb.toString());
            return;
        }
        List<String> ls = map.get(str[idx]);
        for (int i = 0; i < ls.size(); i++) {
            sb.append(ls.get(i));
            helper(res, str, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
