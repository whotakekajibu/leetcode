package recursive.backtracking.permutation_46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Date 2019/11/22 23:42
 **/
public class permutation_46_20191130 {
    public static void main(String[] args) {
        int[] st = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<List<Integer>> res = new ArrayList<>();
        helper(st, 0, res);
        res.forEach(System.out::println);
    }

    /**
     * 123
     */
    static void helper(int[] arr, int idx, List<List<Integer>> res) {
        if (idx == arr.length - 1) {
            res.add(array2List(arr));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            helper(arr, idx + 1, res);
            swap(arr, idx, i);
        }
    }


    static List<Integer> array2List(int[] ints) {
        List<Integer> intList = new ArrayList<>(ints.length);
        for (int i : ints) {
            intList.add(i);
        }
        return intList;
    }

    static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
