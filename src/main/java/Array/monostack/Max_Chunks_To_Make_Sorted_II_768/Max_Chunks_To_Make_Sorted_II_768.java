package Array.monostack.Max_Chunks_To_Make_Sorted_II_768;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * @Date 2020/4/1 11:18
 **/
public class Max_Chunks_To_Make_Sorted_II_768 {
    /**
     * [5,4,3,2,1]
     * [2,1,3,4,4]
     * [4,2,2,1,1]
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 4, 4};
//        int[] arr = {4,2,2,1,1};
//        int[] arr = {2, 0, 1};
//        int[] arr = {4, 3, 2, 1, 5, 0};
        int[] arr = {0, 0, 1, 1, 1};
        System.out.println(maxChunksToSorted(arr));
    }

    /**
     * two heper array
     *
     * @param arr
     * @return
     */
    public static int maxChunksToSorted(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        //forwards[i]为[0-i]最大值
        int[] forwards = new int[arr.length];
        //backwards[i]为[i-n]最小值
        int[] backwards = new int[arr.length];
        forwards[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > forwards[i - 1]) {
                forwards[i] = arr[i];
            } else {
                forwards[i] = forwards[i - 1];
            }
        }
        backwards[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < backwards[i + 1]) {
                backwards[i] = arr[i];
            } else {
                backwards[i] = backwards[i + 1];
            }
        }
        int res = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (forwards[i] <= backwards[i+1]) {
                res++;
            }
        }
        return res;
    }


}
