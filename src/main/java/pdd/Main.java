package pdd;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Scanner in = new Scanner(System.in);
 * int n = in.nextInt();
 * if (n <= 0 || n % 2 != 0) return;
 * in.nextLine();
 * String[] strs = in.nextLine().split(" ");
 * int[] arr = new int[n];
 * for (int i = 0; i < arr.length; i++) {
 * arr[i] = Integer.valueOf(strs[i]);
 * }
 * Arrays.sort(arr);
 * int r = arr.length / 2, l = r - 1;
 * int res = arr[0] + arr[arr.length - 1] - arr[l] - arr[r];
 * System.out.println(String.valueOf(res));
 */
public class Main {
    public static void main(String[] args) {
        List<int[]> ls = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int idx = 0;
        while (idx < n) {
            idx++;
            int cnt = in.nextInt();
            int[] a = new int[cnt];
            in.nextLine();
            String[] strs = in.nextLine().split(" ");
            for (int i = 0; i < cnt; i++) {
                a[i] = Integer.valueOf(strs[i]);
            }
            Arrays.sort(a);
            ls.add(a);
        }
        for (int[] a : ls) {
            System.out.println(min(a, a.length - 1));
        }
    }

    static int min(int[] arr, int i) {
        if (i <= 2) {
            return arr[i];
        }
        return min(arr, i - 3) + 1 + arr[i];
    }


}
