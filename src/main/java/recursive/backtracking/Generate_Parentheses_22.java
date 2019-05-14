package recursive.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    static void dfs(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (open > n || close > n) return;
        if (open == close && open == n) {
            res.add(sb.toString());
            return;
        }
        if (open >= close && open < n) {
            sb.append("(");
            dfs(res, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            dfs(res, sb, open, close + 1, n);
            sb.charAt(sb.length() - 1);
        }
        if (open >= close && open == n) {
            sb.append(")");
            dfs(res, sb, open, close + 1, n);
        }
    }
}
