package online;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KuaiShou_2018_fall {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println(rev(a, b));
	}

	static String rev(int a, int b) {
		StringBuilder sb = new StringBuilder();
		if (a == b)
			return "1";
		int s = 0;
		if (a > b) {
			if (a % b == 0)
				return a / b + "";
			s = a / b;
			a = a - s * b;
		}
		sb.append(s).append(".");
		int len = sb.length();
		int con = a * 10;
		int r = con % b;
		Map<Integer, Integer> m = new HashMap<>();
		Map<String, Integer> idx = new HashMap<>();
		while (true) {
			String key = con + "_" + r;
			if (r == 0) {
				sb.append(con / b);
				break;
			}
			if (m.containsKey(con) && m.get(con) == r) {
				sb.insert(idx.get(key), "(");
				sb.append(")");
				break;
			}
			idx.put(key, len++);
			m.put(con, r);
			sb.append(con / b);
			con = r * 10;
			r = con % b;
		}
		return sb.toString();
	}
}
