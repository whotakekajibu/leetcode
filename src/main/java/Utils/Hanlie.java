package Utils;

import java.util.Scanner;

public class Hanlie {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String[] strs = in.nextLine().split(" ");
//        int m = Integer.parseInt(strs[0]);
//        int n = Integer.parseInt(strs[1]);
//        int k = Integer.parseInt(strs[2]);
        int m = 3;
        int n = 3;
        int k = 6;
        int[][] map = new int[m][n];
        System.out.println(map[0][0]);
        int res = all(map, k, 0, 0);
        System.out.println(res);
    }

    static int all(int[][] map, int k, int x, int y) {
        if (x >= map.length || x < 0 || y >= map[0].length || y < 0) {
            return 0;
        }
        int res = 0;
        if (sumBits(x) + sumBits(y) > k) {
            map[x][y] = 1;
        } else {
            res = 1;
        }
        int left = 0;
        if (x - 1 >= 0 && map[x - 1][y] != 1) {
            map[x - 1][y] = 1;
            left = all(map, k, x - 1, y);
        }

        int right = 0;
        if (x + 1 < map.length && map[x + 1][y] != 1) {
            map[x + 1][y] = 1;
            right = all(map, k, x + 1, y);
        }

        int top = 0;
        if (y + 1 < map.length && map[x][y + 1] != 1) {
            map[x][y + 1] = 1;
            top = all(map, k, x, y + 1);
        }

        int down = 0;
        if (y - 1 >= 0 && map[x][y - 1] != 1) {
            map[x][y - 1] = 1;
            down = all(map, k, x, y - 1);
        }
        int r = left + right + top + down;
        if (r == 0)
            return 0;
        return res + r;
    }

    static int sumBits(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10);
            n /= 10;
        }
        return res;
    }
}
