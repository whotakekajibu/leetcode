package recursive;

import java.util.Arrays;

public class Check_If_Word_Is_Valid_After_Substitutions_1003 {
    public static void main(String[] args) {
        System.out.println(isValid("abcabc"));
    }

    static char[] p = {'a', 'b', 'c'};

    public static boolean isValid(String S) {
        int len = S.length();
        int[][] memo = new int[len + 1][len + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return helper(S.toCharArray(), 0, len - 1, memo);

    }

    static boolean helper(char[] ch, int i, int j, int[][] memo) {
        if (j - i + 1 < p.length) return false;
        if (j - i + 1 == p.length && same(ch, i, j, memo)) {
            return true;
        } else if (same(ch, i, i + p.length - 1, memo) && same(ch, j - p.length + 1, j, memo)) {
            if (j - i + 1 == 2 * p.length){
                return true;
            }
            return helper(ch, i + p.length, j - p.length, memo);
        } else if (same(ch, i, i + p.length - 1, memo)) {
            return helper(ch, i + p.length, j, memo);
        } else if (same(ch, j - p.length + 1, j, memo)) {
            return helper(ch, i, j - p.length, memo);
        } else {
            int t = 0;
            while (ch[i] == p[t]) {
                i++;
                t++;
            }
            if (t == 0) return false;
            t = p.length - t;
            int idx = p.length - 1;
            while (t > 0) {
                if (ch[j] != p[idx]) {
                    return false;
                }
                idx--;
                t--;
                j--;
            }
            return helper(ch, i, j, memo);
        }
    }

    static boolean same(char[] s, int i, int j, int[][] memo) {
        if (memo[i][j] != -1) return memo[i][j] == 1;
        for (int k = 0; k < p.length; k++) {
            if (p[k] != s[k + i]) {
                memo[i][j] = 0;
                return false;
            }
        }
        memo[i][j] = 1;
        return true;
    }
}
