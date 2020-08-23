package sorts;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description
 * @Date 2020/6/5 1:07
 **/
public class HeapSort20200605 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 4, 3};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    public static void buildHeap(int[] arr) {
        int start = arr.length / 2;
        for (int i = start; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    public static void heapify(int[] arr, int n, int idx) {
        int c1 = idx * 2 + 1;
        int c2 = idx * 2 + 2;
        int max = idx;
        if (c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }
        if (max != idx) {
            swap(arr, max, idx);
            heapify(arr, n, max);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
