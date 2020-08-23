package leetcode_cn.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2020/5/10 10:30
 **/
public class Main {
    public static void main(String[] args) {
        int[] target = {2, 3, 4, 5, 8, 9, 10};
        System.out.println(buildArray(target, 10));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        if (target == null || target.length == 0) {
            return ans;
        }
        for (int i = 1, j = 0; i <= n && j < target.length; ) {
            int minus = target[j] - i;
            if (minus > 0) {
                handleMissingNum(ans, minus);
                i += minus;
            } else if (minus == 0) {
                handleExistNum(ans, 1);
                j++;
                i++;
            }
        }
        return ans;
    }

    public static void handleMissingNum(List<String> res, int n) {
        for (int i = 0; i < n; i++) {
            res.add("Push");
            res.add("Pop");
        }
    }


    public static void handleExistNum(List<String> res, int n) {
        for (int i = 0; i < n; i++) {
            res.add("Push");
        }
    }
}
