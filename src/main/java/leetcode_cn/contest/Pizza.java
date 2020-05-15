package leetcode_cn.contest;

import Utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/5/10 16:59
 **/
public class Pizza {
    static int[][] row;
    static Map<String, Long> map;

    public static void main(String[] args) {
        String[] pizza = {"..A.A.AAA...AAAAAA.AA..A..A.A......A.AAA.AAAAAA.AA","A.AA.A.....AA..AA.AA.A....AAA.A........AAAAA.A.AA.","A..AA.AAA..AAAAAAAA..AA...A..A...A..AAA...AAAA..AA","....A.A.AA.AA.AA...A.AA.AAA...A....AA.......A..AA.","AAA....AA.A.A.AAA...A..A....A..AAAA...A.A.A.AAAA..","....AA..A.AA..A.A...A.A..AAAA..AAAA.A.AA..AAA...AA","A..A.AA.AA.A.A.AA..A.A..A.A.AAA....AAAAA.A.AA..A.A",".AA.A...AAAAA.A..A....A...A.AAAA.AA..A.AA.AAAA.AA.","A.AA.AAAA.....AA..AAA..AAAAAAA...AA.A..A.AAAAA.A..","A.A...A.A...A..A...A.AAAA.A..A....A..AA.AAA.AA.AA.",".A.A.A....AAA..AAA...A.AA..AAAAAAA.....AA....A....","..AAAAAA..A..A...AA.A..A.AA......A.AA....A.A.AAAA.","...A.AA.AAA.AA....A..AAAA...A..AAA.AAAA.A.....AA.A","A.AAAAA..A...AAAAAAAA.AAA.....A.AAA.AA.A..A.A.A...","A.A.AA...A.A.AA...A.AA.AA....AA...AA.A..A.AA....AA","AA.A..A.AA..AAAAA...A..AAAAA.AA..AA.AA.A..AAAAA..A","...AA....AAAA.A...AA....AAAAA.A.AAAA.A.AA..AA..AAA","..AAAA..AA..A.AA.A.A.AA...A...AAAAAAA..A.AAA..AA.A","AA....AA....AA.A......AAA...A...A.AA.A.AA.A.A.AA.A","A.AAAA..AA..A..AAA.AAA.A....AAA.....A..A.AA.A.A...","..AA...AAAAA.A.A......AA...A..AAA.AA..A.A.A.AA..A.",".......AA..AA.AAA.A....A...A.AA..A.A..AAAAAAA.AA.A",".A.AAA.AA..A.A.A.A.A.AA...AAAA.A.A.AA..A...A.AAA..","A..AAAAA.A..A..A.A..AA..A...AAA.AA.A.A.AAA..A.AA..","A.AAA.A.AAAAA....AA..A.AAA.A..AA...AA..A.A.A.AA.AA",".A..AAAA.A.A.A.A.......AAAA.AA...AA..AAA..A...A.AA","A.A.A.A..A...AA..A.AAA..AAAAA.AA.A.A.A..AA.A.A....","A..A..A.A.AA.A....A...A......A.AA.AAA..A.AA...AA..",".....A..A...A.A...A..A.AA.A...AA..AAA...AA..A.AAA.","A...AA..A..AA.A.A.AAA..AA..AAA...AAA..AAA.AAAAA...","AA...AAA.AAA...AAAA..A...A..A...AA...A..AA.A...A..","A.AA..AAAA.AA.AAA.A.AA.A..AAAAA.A...A.A...A.AA....","A.......AA....AA..AAA.AAAAAAA.A.AA..A.A.AA....AA..",".A.A...AA..AA...AA.AAAA.....A..A..A.AA.A.AA...A.AA","..AA.AA.AA..A...AA.AA.AAAAAA.....A.AA..AA......A..","AAA..AA...A....A....AA.AA.AA.A.A.A..AA.AA..AAA.AAA","..AAA.AAA.A.AA.....AAA.A.AA.AAAAA..AA..AA.........",".AA..A......A.A.AAA.AAAA...A.AAAA...AAA.AAAA.....A","AAAAAAA.AA..A....AAAA.A..AA.A....AA.A...A.A....A..",".A.A.AA..A.AA.....A.A...A.A..A...AAA..A..AA..A.AAA","AAAA....A...A.AA..AAA..A.AAA..AA.........AA.AAA.A.","......AAAA..A.AAA.A..AAA...AAAAA...A.AA..A.A.AA.A.","AA......A.AAAAAAAA..A.AAA...A.A....A.AAA.AA.A.AAA.",".A.A....A.AAA..A..AA........A.AAAA.AAA.AA....A..AA",".AA.A...AA.AAA.A....A.A...A........A.AAA......A...","..AAA....A.A...A.AA..AAA.AAAAA....AAAAA..AA.AAAA..","..A.AAA.AA..A.AA.A...A.AA....AAA.A.....AAA...A...A",".AA.AA...A....A.AA.A..A..AAA.A.A.AA.......A.A...A.","...A...A.AA.A..AAAAA...AA..A.A..AAA.AA...AA...A.A.","..AAA..A.A..A..A..AA..AA...A..AA.AAAAA.A....A..A.A"};
        int k = 8;
        System.out.println(ways(pizza, k));
    }

    public static int ways(String[] pizza, int k) {
        if (pizza.length == 0) {
            return 0;
        }
        int column = pizza[0].length();
        row = new int[pizza.length][column];
        map = new HashMap<>();
        for (int i = 0; i < pizza.length; i++) {
            int cnt = 0;
            for (int j = column - 1; j >= 0; j--) {
                if (pizza[i].charAt(j) == 'A') {
                    cnt++;
                }
                row[i][j] = cnt;
            }
        }
        for (int j = 0; j < column; j++) {
            for (int i = pizza.length - 2; i >= 0; i--) {
                row[i][j] += row[i + 1][j];
            }
        }
        Utils.printTwoDimensionalArray(row);
        return (int) (helper(pizza, 0, 0, k) % (Math.pow(10, 9) + 7));
    }

    public static long helper(String[] pizza, int i, int j, int k) {
        if (i >= pizza.length || j >= pizza[0].length()) {
            return 0;
        }
        String key = i + "_" + j + "_" + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (k == 1) {
            if (row[i][j] > 0) {
                map.put(key, 1L);
                return 1;
            }
            map.put(key, 0L);
            return 0;
        }
        long h = 0, v = 0;
        //水平切
        for (int m = i + 1; m < row.length; m++) {
            if (row[i][j] - row[m][j] == 0) {
                continue;
            }
            h += helper(pizza, m, j, k - 1);
        }
        //竖直切
        for (int n = j + 1; n < row[i].length; n++) {
            if (row[i][j] - row[i][n] == 0) {
                continue;
            }
            v += helper(pizza, i, n , k - 1);
        }
        map.put(key,v+h);
        return v + h;
    }
}
