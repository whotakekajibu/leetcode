package permutation;


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
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] arr = new int[n];
        String[] str = in.nextLine().split(" ");
        in.close();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(str[i]);
        }
        int[] memo = new int[arr.length];
        System.out.println(min(arr, memo, arr.length - 1));
    }

    static int min(int[] arr, int[] memo, int i) {
        if (memo[i] != 0) return memo[i];
        if (i == 0) {
            if (arr[i] % 2 == 0) {
                return memo[i] = arr[i] / 2;
            }
            return memo[i] = arr[i] / 2 + 1;
        }
        int pre = min(arr, memo, i - 1);
        if (pre - (arr[i] - pre) > 0) {
            return memo[i] = pre;

        }
        return memo[i] = arr[i];
    }


}
