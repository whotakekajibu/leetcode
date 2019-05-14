package recursive.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number_17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        dfs(digits, 0, res, new StringBuilder());
        return res;
    }

    static void dfs(String digits, int cur, List<String> res, StringBuilder sb) {
        if (cur == digits.length()) {
            if (sb.length() == 0) return;
            res.add(sb.toString());
            return;
        }
        int num = Character.getNumericValue(digits.charAt(cur));
        String str = map[num - 2];
        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            dfs(digits, cur + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
