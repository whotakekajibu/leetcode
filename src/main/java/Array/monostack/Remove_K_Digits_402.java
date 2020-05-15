package Array.monostack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * @Date 2020/4/1 15:28
 **/
public class Remove_K_Digits_402 {
    /**
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(num);
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length && k > 0; i++) {
            while (!stack.isEmpty() && chars[stack.peek()] > chars[i]) {
                stack.pop();
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
