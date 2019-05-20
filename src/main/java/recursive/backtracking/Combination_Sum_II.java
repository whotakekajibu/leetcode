package recursive.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    public static void main(String[] args) {
        int[] arr = {14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12};
        System.out.println(combinationSum2(arr, 27));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    static void dfs(List<List<Integer>> res, List<Integer> ls, int[] arr, int cur, int tar) {
        if (cur == arr.length || tar == 0) {
            if (tar == 0) {
                for (List<Integer> re : res) {
                    int i;
                    if (ls.size() == re.size() && ls.get(ls.size() - 1) == re.get(re.size() - 1)) {
                        i = ls.size() - 2;
                        while (i >= 0) {
                            if (ls.get(i) != re.get(i)) {
                                break;
                            }
                            i--;
                        }
                        if (i == -1) {
                            return;
                        }
                    }
                }
                res.add(new ArrayList<>(ls));
            }
            return;
        }
        if (arr[cur] > tar) return;
        dfs(res, ls, arr, cur + 1, tar);
        ls.add(arr[cur]);
        dfs(res, ls, arr, cur + 1, tar - arr[cur]);
        ls.remove(ls.size() - 1);
    }
}
