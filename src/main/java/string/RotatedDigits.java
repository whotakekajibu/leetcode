package string;

public class RotatedDigits {

	public static void main(String[] args) {
		int res = rotatedDigits(35);
		System.out.println(res);
	}

	public static int rotatedDigits(int N) {
		int res = 0;
		int[] m = { 0, 1, 5, -1, -1, 2, 9, -1, 8, 6 };
		for (int i = 2; i <= N; i++) {
			if (i < 10) {
				if (m[i] != -1 && m[i] != i)
					res++;
			} else {
				int tmp = i;
				int cures = 0;
				int bt = 0;
				int curBit = 0;
				while (tmp != 0) {
					curBit = tmp % 10;
					tmp /= 10;
					if (m[curBit] == -1) {
						break;
					}
					cures = (int) (m[curBit] * Math.pow(10, bt) + cures);
					bt++;
				}
				if (m[curBit] != -1 && cures != i) {
					res++;
					System.out.println(i);
				}
			}
		}
		return res;
	}

}
