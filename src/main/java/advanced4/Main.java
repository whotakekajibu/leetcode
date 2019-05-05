package advanced4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 3) {
            System.out.println(0);
            return;
        }
        in.nextLine();
        String[] strs = in.nextLine().split(" ");
        int[] arr = new int[n];
        in.close();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        int firstP = Integer.MIN_VALUE;
        int secondP = Integer.MIN_VALUE;
        int thirdP = Integer.MIN_VALUE;

        int firstN = Integer.MAX_VALUE;
        int secondN = Integer.MAX_VALUE;
        boolean hasZero = false;
        for (int i : arr) {
            if (i == 0) {
                hasZero = true;
                continue;
            }
            if (i > firstP) {
                thirdP = secondP;
                secondP = firstP;
                firstP = i;
            } else if (i <= firstP && i > secondP) {
                thirdP = secondP;
                secondP = i;
            } else if (i <= thirdP && i > thirdP) {
                thirdP = i;
            }
            if (i > 0) continue;
            if (i < firstN) {
                secondN = firstN;
                firstN = i;
            } else if (i >= firstN && i < secondP) {
                secondN = i;
            }
        }
        int res = Integer.MIN_VALUE;
        if (firstP < 0) {
            System.out.println(0);
            return;
        }
        else if (secondP < 0){
            res = firstN * secondN * firstP;

        }else if (thirdP < 0){
            res = firstN * secondN * firstP;
        }else if (secondN < 0){
            res = Math.max(firstP * secondP * thirdP,firstN * secondN * firstP);
        }else if (secondN == Integer.MAX_VALUE){
            res = firstN * secondN * firstP;
        }
        System.out.println(res);

    }

    static int max(int[] nums) {
        int res = nums[0];
        for (int n : nums) {
            if (n > res) {
                res = n;
            }
        }
        return res;
    }
}
