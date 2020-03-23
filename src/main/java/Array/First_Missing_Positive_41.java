package Array;

import java.util.Arrays;

public class First_Missing_Positive_41 {
    public static void main(String[] args) {
//        int[] arr = {3, 4, 2, 1};
        int[] arr = {7,8,9,11,12};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            while (arr[i] > 0 && arr[i] <= len && arr[arr[i] - 1] != arr[i]) {
                int tmp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = tmp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}