package leetcode_cn.may;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description
 * @Date 2020/5/29 1:02
 **/
public class Decode_String_394 {


    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        stack.offer(String.valueOf(s.charAt(0)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.offer(String.valueOf(c));
            } else if (c == ']') {

            } else if (c >= '0' && c <= '9') {
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(c));
                } else if (Character.isAlphabetic(stack.peek().charAt(0))) {
                    String poll = stack.poll();
                    stack.offer(poll + c);
                } else {

                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "/a//b////c/d//././/..";
        for (String s1 : s.split("/")) {
            System.out.println(s1.length() + "_"+ s1);
        }
    }

    public static int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            System.out.println(mid);
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
