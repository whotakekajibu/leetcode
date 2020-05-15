package Array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2020/3/21 16:31
 **/
public class Remove_Duplicate_Letters_316 {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        char[] map = new char[26];
        char[] chars = s.toCharArray();
        boolean[] exist = new boolean[26];
        for (char c : chars) {
            map[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            int curIdx = c - 'a';
            map[curIdx]--;
            while (!stack.isEmpty() && c < stack.peek() && map[stack.peek() - 'a'] > 0 && !exist[c - 'a']) {
                exist[stack.peek() - 'a'] = false;
                stack.pop();
            }
            if (exist[c - 'a']){
                continue;
            }
            stack.push(c);
            exist[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static String removeDuplicateLettersWrongAnswer(String s) {
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
