package recursive;

public class Edit_Distance_72 {
    public static void main(String[] args) {
//        String s = "ab",p="a";
        String s = "intention", p = "execution";
        System.out.println(minDistance(s, p));
    }

    public static int minDistance(String word1, String word2) {
        return helper(word1.toCharArray(), 0, word2.toCharArray(), 0);
    }

    static int helper(char[] s, int i, char[] p, int j) {
        if (i == s.length && j == p.length) {
            return 0;
        } else if (i == s.length) {
            return p.length - j;
        } else if (j == p.length) {
            return s.length - i;
        } else if (s[i] == p[j]) {
            return helper(s, i + 1, p, j + 1);
        } else {
            int delete = helper(s, i + 1, p, j);
            int insert = helper(s, i, p, j + 1);
            int replace = helper(s, i + 1, p, j + 1);
            return min3(delete, insert, replace) + 1;
        }
    }

    static int min3(int a, int b, int c) {
        if (a > b) {
            a = b;
        }
        if (a > c) {
            a = c;
        }
        return a;
    }
}
