package sorts;

import Utils.SortUtils;
import singleton.Singleton;

public class MergeSort {
    public static void main(String[] args) {
        Singleton t = Singleton.getInstance();
        System.out.println(t);
//		int[] arr = { 9, 6, 1, 8, 3, 6, 0, 7 };
//		// mergeSort(arr, 0, arr.length - 1);
//		for (int e : arr) {
//			System.out.println(e);
//		}
//		int[] test = { 5, Integer.MAX_VALUE, 6, Integer.MAX_VALUE };
//		mergeWithSentinel(test, 0, 1, 3);
    }

    public static void mergeSort(int[] arr, int i, int j) {
        if (j == i)
            return;
        int mid = (j + i) / 2;
        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, j);
        mergeWithSentinel(arr, i, mid, j);
    }

    public static void mergeWithSentinel(int[] arr, int i, int m, int j) {
        int leftLen = m - i + 1;
        int rightLen = j - m;
        int[] left = new int[leftLen + 1];
        int[] right = new int[rightLen + 1];
        left[leftLen] = Integer.MAX_VALUE;
        right[rightLen] = Integer.MAX_VALUE;
        System.arraycopy(arr, i, left, 0, leftLen);
        System.arraycopy(arr, m + 1, right, 0, rightLen);
        int ldx = 0, rdx = 0;
        for (int k = i; k <= j; k++) {
            if (left[ldx] <= right[rdx]) {
                arr[i++] = left[ldx++];
            } else {
                arr[i++] = right[rdx++];
            }
        }
    }
}
