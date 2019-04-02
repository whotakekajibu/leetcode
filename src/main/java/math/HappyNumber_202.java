package math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}

	static Set<Integer> sets = new HashSet<>();

	public static boolean isHappy(int n) {
		if (n == 1)
			return true;
		if (sets.contains(n))
			return false;
		int tmp = 0;
		sets.add(n);
		while (n != 0) {
			tmp += (n % 10) * (n % 10);
			n /= 10;
		}
		return isHappy(tmp);
	}
}
