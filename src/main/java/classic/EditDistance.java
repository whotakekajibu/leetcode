package classic;

import java.util.Arrays;

/**
 * @Description
 * @Date 2020/4/26 10:15
 **/
public class EditDistance {
    public static void main(String[] args) {
//        System.out.println(editDistance("horse", "ros"));
        System.out.println(editDistance("horse", ""));
    }

    static int[][] map;

    public static int editDistance(String s, String p) {
        map = new int[s.length()][p.length()];
        for (int[] ints : map) {
            Arrays.fill(ints, -1);
        }
        return helper(s, 0, p, 0);
    }

    public static int editDistanceDp(String s, String p) {
        return helper(s, 0, p, 0);
    }

    public static int helper(String s, int i, String p, int j) {
        if (map[i][j] != -1) {
            return map[i][j];
        }
        if (i == s.length()) {
            return map[i][j] = p.length() - j;
        }
        if (j == p.length()) {
            return map[i][j] = s.length() - i;
        }
        if (s.charAt(i) == p.charAt(j)) {
            return map[i][j] = helper(s, i + 1, p, j + 1);
        } else {
            int delete = 1 + helper(s, i + 1, p, j);
            int replace = 1 + helper(s, i + 1, p, j + 1);
            int insert = 1 + helper(s, i, p, j + 1);
            return map[i][j] = min(delete, replace, insert);
        }
    }

    public static int min(int a, int b, int c) {
        if (a > b) {
            a = b;
        }
        if (a > c) {
            a = c;
        }
        return a;
    }
}
