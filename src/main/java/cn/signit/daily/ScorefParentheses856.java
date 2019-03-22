package cn.signit.daily;

public class ScorefParentheses856 {

	public static void main(String[] args) {
		ScorefParentheses856 sp = new ScorefParentheses856();
//		System.out.println(sp.scoreOfParentheses("(()(()))"));
//		System.out.println(sp.scoreOfParentheses("()"));
		System.out.println('a'-'A');
		System.out.println('f'-'F');

	}

	public int scoreOfParentheses(String S) {
		return helper(S, 0, S.length() - 1);
	}

	// (()(())) ()() ((()))
	int helper(String s, int l, int r) {
		if (r - l == 1)
			return 1;
		int b = 0;
		for (int i = l; i < r; i++) {
			if (s.charAt(i) == '(') {
				b++;
			}
			if (s.charAt(i) == ')') {
				b--;
			}
			if (b == 0) {
				return helper(s, l, i) + helper(s, i + 1, r);
			}
		}
		return 2 * helper(s, l + 1, r - 1);
	}
}
