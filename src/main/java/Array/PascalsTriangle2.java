package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public static void main(String[] args) {
        getRow(3);
    }

    public static List<Integer> getRow(int i) {
//        Pascal's Triangle II
        List<Integer> list = new ArrayList<>();
        int[] res = helper(new int[i + 1], 0);
        for (int re : res) {
            list.add(re);
        }
        return list;
    }

    /**
     * 1 0 0 0 0
     * 1 1 0 0 0
     * 1 2 1 0 0
     * 1 3 3 1 0
     * 1 4 6 4 1
     */
    static int[] helper(int[] res, int cur) {
        int[] tmp = new int[res.length];
        for (int i = 0; i <= cur; i++) {
            if (i == 0) {
                tmp[i] = 1;
            } else {
                tmp[i] = res[i - 1] + res[i];
            }
        }
        res = tmp;
        if (res.length - 1 == cur)
            return res;
        return helper(res, cur + 1);
    }

}
