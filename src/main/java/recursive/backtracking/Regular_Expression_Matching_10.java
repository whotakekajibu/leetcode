package recursive.backtracking;

public class Regular_Expression_Matching_10 {
    public static void main(String[] args) {
        String s = "ba", p = ".*a*a";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int[][] memo = new int[ss.length][ps.length];
        return helper(ss, 0, ps, 0);
    }

    static boolean helper(char[] s, int i, char[] p, int j) {
        if (i == s.length) {
            if (j == p.length) {
                return true;
            }
            if (j + 2 <= p.length && p[j] != '*' && p[j + 1] == '*') {
                return helper(s, i, p, j + 2);
            }
            return false;
        }
        if (j == p.length) {
            return i == s.length;
        }
        if (j + 1 < p.length) {
            if (p[j + 1] == '*') {
                if (p[j] == '.') {
                    return helper(s, i + 1, p, j) || helper(s, i + 1, p, j + 2) || helper(s, i, p, j + 2);
                }
                if (s[i] != p[j]) {
                    return helper(s, i, p, j + 2);
                }
                return helper(s, i + 1, p, j) || helper(s, i + 1, p, j + 2) || helper(s, i, p, j + 2);
            } else {
                if (p[j] == '.') {
                    return helper(s, i + 1, p, j + 1);
                }
                if (s[i] != p[j]) {
                    return false;
                }
                return helper(s, i + 1, p, j + 1);
            }
        } else {
            if (p[j] == '.') {
                return helper(s, i + 1, p, j + 1);
            } else {
                return s[i] == p[j] && helper(s, i + 1, p, j + 1);
            }
        }
    }
}
