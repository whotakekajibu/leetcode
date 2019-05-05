package classic;

import java.util.Scanner;

public class LCS {

    public static void main(String[] args) {
        //abcfbc abfcab
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String[] a = in.nextLine().split(" ");
            char[] ch1 = a[0].toCharArray();
            char[] ch2 = a[1].toCharArray();
            m = new int[ch1.length][ch2.length];
            System.out.println(LCS(ch1, ch1.length - 1, ch2, ch2.length - 1));
        }
    }

    static int[][] m;

    static int LCS(char[] a, int i, char[] b, int j) {
        if (i < 0 || j < 0) return 0;
        if (m[i][j] != 0) return m[i][j];

        if (a[i] == b[j]) {
            return m[i][j] = 1 + LCS(a, i - 1, b, j - 1);

        }
        return m[i][j] = Math.max(LCS(a, i - 1, b, j), LCS(a, i, b, j - 1));
    }
}
