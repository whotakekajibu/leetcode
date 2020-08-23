package niuke;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description
 * @Date 2020/8/1 20:46
 **/
public class Min {
    static int[][] memo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }
        memo = new int[arr.length + 1][2];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        int steps = steps(arr, 0, 0);
        if (steps > 200) {
            System.out.println("-1");
            return;
        }
        System.out.println(steps);
    }

    public static int steps(int[] arr, int i, int first) {
        if (first == 0) {
            if (memo[i][first] != -1){
                return memo[i][first];
            }
            int ans = Integer.MAX_VALUE;
            for (int idx = 1; idx < arr[0]; idx++) {
                int curSteps = steps(arr, idx, 1) + 1;
                ans = Math.min(ans, curSteps);
            }
            return memo[i][first]=ans;
        } else {
            if (i == arr.length - 1) {
                return 0;
            }
            if (i >= arr.length) {
                return 500;
            }
            if (memo[i][first] != -1){
                return memo[i][first];
            }
            return memo[i][first]= 1 + steps(arr, i + arr[i], 1);
        }
    }
}
