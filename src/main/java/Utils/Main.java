package Utils;

import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int res = 0;
        while (a != 0){
            res ++;
            a = a & (a - 1);
        }
        System.out.println(res);
    }
}
