package Utils;

public class Utils {
	public static void main(String[] args) {
		System.out.println(max3(2, 3, 1));
		System.out.println(min3(2, 3, 1));
	}

	public static int max3(int a, int b, int c) {
		if (a < b)
			a = b;
		if (a < c)
			a = c;
		return a;
	}

	public static int min3(int a, int b, int c) {
		if (a > b)
			a = b;
		if (a > c)
			a = c;
		return a;
	}

}
