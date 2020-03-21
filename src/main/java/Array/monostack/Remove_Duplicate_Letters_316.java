package Array.monostack;

import java.util.*;

public class Remove_Duplicate_Letters_316 {
    public static void main(String[] args) {
//        String str = "bcabc";
//        String str = "cbacdcbc";
        String str = "abacb";
        System.out.println(removeDuplicateLetters(str));
    }

    public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            Integer cnt = map.get(c);
            if (cnt == null) {
                map.put(c, 1);
            } else {
                map.put(c, cnt + 1);
            }
        }
        Deque<Character> stack = new ArrayDeque<>();
        //cbacdcbc
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.isEmpty() || stack.peek() < cur && !stack.contains(cur)) {
                stack.push(cur);
                map.put(cur, map.get(cur) - 1);
            } else {
                while (!stack.isEmpty() && stack.peek() >= cur) {
                    char peek = stack.peek();
                    Integer peekCnt = map.get(peek);
                    if (peekCnt == 0) {
                        break;
                    }
                    stack.pop();
                }
                if (stack.isEmpty() || !stack.contains(cur)) {
                    stack.push(cur);
                    map.put(cur, map.get(cur) - 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
