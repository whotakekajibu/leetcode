package recursive;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        helper(res, numRows - 1);
        return res;
    }

    static void helper(List<List<Integer>> res, int level) {
        if (level < 0) return;
        helper(res, level - 1);
        List<Integer> ls = new ArrayList<>(level + 1);
        for (int i = 0; i <= level; i++) {
            if (i == 0 || i == level) {
                ls.add(1);
                continue;
            }
            ls.add(res.get(level - 1).get(i - 1) + res.get(level - 1).get(i));
        }
        res.add(ls);
    }
}
