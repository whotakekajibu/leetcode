package dp;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
   not optimal solution
 * @Date 2020/1/12 16:56
 **/
public class Minimum_Flips_to_Make_a_OR_b_Equal_to_1318 {
    public static void main(String[] args) {
        System.out.println(minFlips(8, 3, 5));
    }

    ////////////////////////////////////////////memoization////////////////////////////////////////////////////
    public static int minFlips(int a, int b, int c) {
        int dc = c, cnt = 0;
        while (dc != 0) {
            cnt++;
            dc = dc & (dc - 1);
        }
        char[] ac = alignZero(Integer.toBinaryString(a).toCharArray());
        char[] bc = alignZero(Integer.toBinaryString(b).toCharArray());
        char[] cc = alignZero(Integer.toBinaryString(c).toCharArray());
        return helper(ac, bc, cc, 30);
    }

    /**
     * 00 111
     *
     * @param old
     * @return
     */
    public static char[] alignZero(char[] old) {
        if (old.length == 31) {
            return old;
        }
        int oldLen = old.length;
        int minusLen = 31 - oldLen;
        char[] newArr = new char[31];
        for (int i = 0; i < minusLen; i++) {
            newArr[i] = '0';
        }
        for (int i = 0; i < oldLen; i++) {
            newArr[i + minusLen] = old[i];
        }
        return newArr;
    }

    public static int helper(char[] a, char[] b, char[] c, int idx) {
        if (idx < 0) {
            return 0;
        }
        if (a[idx] == b[idx] && b[idx] == c[idx]) {
            if (c[idx] == '1') {
                return helper(a, b, c, idx - 1);
            }
            return helper(a, b, c, idx - 1);
        } else {
            if (c[idx] == '1') {
                if (a[idx] == '1' || b[idx] == '1') {
                    return helper(a, b, c, idx - 1);
                }
                return helper(a, b, c, idx - 1) + 1;
            } else {
                if (a[idx] == '0' || b[idx] == '0') {
                    return helper(a, b, c, idx - 1) + 1;
                }
                return helper(a, b, c, idx - 1) + 2;
            }
        }
    }
    ////////////////////////////////////////////memoization////////////////////////////////////////////////////
}
