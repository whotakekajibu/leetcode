package recursive;


import java.util.ArrayList;
import java.util.List;

/**

 */
public class Edit_Distance_72 {
    public static void main(String[] args) {
        String s = "horse", p = "ros";
        System.out.println(helper(s, p));
    }

    public static int helper(String w1, String w2) {
        return helper(w1.toCharArray(), 0, w2.toCharArray(), 0);
    }

    public static int helper(char[] w, int i, char[] p, int j) {
        if (w.length - i == p.length - j && compare(w,i,p,j)){
            return 0;
        }
        if (i == w.length && j == p.length) {
            return 0;
        } else if (j == p.length) {
            return w.length - i;
        } else if (i == w.length) {
            return p.length - j;
        } else {
            int delete = helper(w, i + 1, p, j);
            int insert = helper(w, i, p, j + 1);
            int replace = helper(w, i + 1, p, j + 1);
            return Math.min(delete, Math.min(insert, replace)) + 1;
        }
    }

    static boolean compare(char[] w,int i,char[] p,int j){
        int cnt = w.length - i;
        while (cnt > 0){
            cnt--;
            if (w[i++] != p[j++]){
                return false;
            }
        }
        return true;
    }
}
