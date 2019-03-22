package longgest;

public class LongestCommonSequence {
	public static void main(String[] args) {
		LongestCommonSequence lcs = new LongestCommonSequence();
//		System.out.println(lcs.lcs("abcbdab", "bdcaba"));
		System.out.println(lcs.lcs("abad", "abcd"));
		
//		String str1 = "ABC1234567DEFG";
//		String str2 = "HIJKL1234567MNOP";
//		System.out.println(lcst1(str1, str2));
//		System.out.println(lcst2(str1, str2));
	}

	public int lcs(String s1, String s2) {
		return LCSLength(s1, s2, s1.length() - 1, s2.length() - 1);
	}

	int LCSLength(String X, String Y, int m, int n) {
		// return if we have reached the end of either sequence
		if (m == 0 || n == 0)
			return 0;
		// if last character of X and Y matches
		if (X.charAt(m) == Y.charAt(n))
			return LCSLength(X, Y, m - 1, n - 1) + 1;
		// else if last character of X and Y don't match
		return Math.max(LCSLength(X, Y, m, n - 1), LCSLength(X, Y, m - 1, n));
	}

	public static String lcst1(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdp(chs1, chs2);
		int end = 0;
		int max = 0;
		for (int i = 0; i < chs1.length; i++) {
			for (int j = 0; j < chs2.length; j++) {
				if (dp[i][j] > max) {
					end = i;
					max = dp[i][j];
				}
			}
		}
		return str1.substring(end - max + 1, end + 1);
	}

	public static int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		for (int i = 0; i < str1.length; i++) {
			if (str1[i] == str2[0]) {
				dp[i][0] = 1;
			}
		}
		for (int j = 1; j < str2.length; j++) {
			if (str1[0] == str2[j]) {
				dp[0][j] = 1;
			}
		}
		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				if (str1[i] == str2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		return dp;
	}

	public static String lcst2(String str1, String str2) {
		if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
			return "";
		}
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int row = 0;
		int col = chs2.length - 1;
		int max = 0;
		int end = 0;
		while (row < chs1.length) {
			int i = row;
			int j = col;
			int len = 0;
			while (i < chs1.length && j < chs2.length) {
				if (chs1[i] != chs2[j]) {
					len = 0;
				} else {
					len++;
				}
				if (len > max) {
					end = i;
					max = len;
				}
				i++;
				j++;
			}
			if (col > 0) {
				col--;
			} else {
				row++;
			}
		}
		return str1.substring(end - max + 1, end + 1);
	}

}
