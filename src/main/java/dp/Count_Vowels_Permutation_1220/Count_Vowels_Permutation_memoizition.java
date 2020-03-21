package dp.Count_Vowels_Permutation_1220;

import java.util.Arrays;
import java.util.List;

public class Count_Vowels_Permutation_memoizition {
    public static void main(String[] args) {
        System.out.println(countVowelPermutation(20));
    }

    public static int countVowelPermutation(int n) {
        int ans = 0;
        if (n == 1) {
            return 5;
        }
        List<Character> ls = Arrays.asList('a', 'e', 'i', 'o', 'u');

        for (Character l : ls) {
            ans += helper(l, n-1);
        }
        return ans;
    }

    public static int helper(char pre, int cnt) {
        if (0 == cnt) {
            return 1;
        }
        if (pre == 'a') {
            return helper('e', cnt - 1);
        }
        if (pre == 'e') {
            return helper('a', cnt - 1) + helper('i', cnt - 1);
        }
        if (pre == 'i') {
            return helper('a', cnt - 1) + helper('e', cnt - 1) + helper('o', cnt - 1) + helper('u', cnt - 1);
        }
        if (pre == 'o') {
            return helper('i', cnt - 1) + helper('u', cnt - 1);
        }
        else  {
            return helper('a', cnt - 1);
        }
    }


}
