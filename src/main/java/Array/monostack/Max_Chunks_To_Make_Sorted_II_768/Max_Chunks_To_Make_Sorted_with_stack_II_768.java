package Array.monostack.Max_Chunks_To_Make_Sorted_II_768;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description
 * @Date 2020/4/1 11:18
 **/
public class Max_Chunks_To_Make_Sorted_with_stack_II_768 {
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
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || stack.peek() <= arr[i]) {
                stack.push(arr[i]);
            } else {
                Integer curMax = stack.pop();
                while (!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                stack.push(curMax);
            }
        }
        return stack.size();
    }


}
