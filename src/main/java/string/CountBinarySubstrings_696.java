package string;

public class CountBinarySubstrings_696 {

	public static void main(String[] args) {
		System.out.println(countBinarySubstrings("1110000100"));
	}

	// "1110100"
	public static int countBinarySubstrings(String s) {
		char[] ch = s.toCharArray();
		int i = 0, j = 0, cnt = 0, res = 0;
		boolean notsame = false;
		while (j < ch.length) {
			if (ch[j] == ch[i]) {
				if (notsame && cnt > 0) {
					i = j - (j - cnt) / 2;
					j = i;
					cnt = 0;
					continue;
				} else {
					cnt++;
				}
				notsame = false;
			} else {
				res++;
				cnt--;
				if (cnt == 0) {
					i = (j - i) / 2 + 1;
					j = i;
					cnt = 0;
					continue;
				}
				notsame = true;
			}
			j++;
		}
		return res;
	}
}
