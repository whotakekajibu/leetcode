package leetcode_cn.april;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/4/25 9:37
 **/
public class Permutation_46 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        for (List<Integer> integers : permute(arr)) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(arr, ans, cur, 0);
        return ans;
    }

    public static void helper(int[] arr, List<List<Integer>> ans, List<Integer> cur, int idx) {
        if (idx == arr.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            cur.add(arr[idx]);
            helper(arr, ans, cur, idx + 1);
            cur.remove(cur.size() - 1);
            swap(arr, idx, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
