package leetcode_cn.april;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Date 2020/4/9 17:38
 **/
public class Generate_Parenthesis_22_2020_0409 {

    public static void main(String[] args) {
        for (String parenthesis : generateParenthesis(3)) {
            System.out.println(parenthesis);
        }
    }

    public static List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        if (n == 0) {
            return new ArrayList<>(res);
        }
        if (n == 1) {
            res.add("()");
            return new ArrayList<>(res);
        }
        helper(res, new StringBuilder("()"), n);
        return new ArrayList<>(res);
    }


    public static void helper(Set<String> res, StringBuilder sb, int n) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < sb.length(); i++) {
            if (i > 0 && sb.charAt(i - 1) == ')' && sb.charAt(i) == '(') {
                continue;
            }
            sb.insert(i, "()");
            helper(res, sb, n);
            sb.delete(i, i + 2);
        }
    }
}
