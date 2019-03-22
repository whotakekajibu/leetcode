package recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCasePermutation784 {

	public static void main(String[] args) {
		String s = "ab";
		LetterCasePermutation784 lcp = new LetterCasePermutation784();
		lcp.letterCasePermutation(s);
	}

	public List<String> letterCasePermutation(String S) {
		List<String> list = new ArrayList<>();
		// helper(S, 0, list);
		helperHuaHua(S.toCharArray(), 0, list);
		// Set<String> set = new HashSet<>(list);
		list.stream().forEach(System.out::println);
		return list;
	}

	// 自己的方法
	void helper(String s, int i, List<String> list) {
		if (i == s.length()) {
			list.add(s);
			return;
		}
		char[] chars = s.toCharArray();
		char tmp = chars[i];
		if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
			chars[i] -= 32;
		} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
			chars[i] += 32;
		}
		helper(new String(chars), i + 1, list);
		if (tmp != chars[i]) {
			chars[i] = tmp;
			helper(new String(chars), i + 1, list);
		}
	}

	//////////////// 视频讲义后的做法
	void helperHuaHua(char[] chars, int i, List<String> list) {
		if (i == chars.length) {
			list.add(new String(chars));
			return;
		}
		helperHuaHua(chars, i + 1, list);
		if (Character.isDigit(chars[i]))
			return;
		chars[i] ^= (1 << 5);
		helperHuaHua(chars, i + 1, list);
		// chars[i] ^= (1 << 5);
	}
}
