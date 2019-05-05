package sorts;

import Utils.SortChecker;

import java.util.Arrays;

public class QuickSort20190416 implements SortChecker.Sort {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            SortChecker.Check(new QuickSort20190416());
        }

    }

    @Override
    public void sort(int[] arr) {
        QuickSort(arr, 0, arr.length - 1);
    }


    //将[begin,end]区间内的元素从小到大排序
    private static void QuickSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int[] left = partion(arr, begin, end);
        QuickSort(arr, begin, left[0] - 1);
        QuickSort(arr, left[1] + 1, end);
    }

    private static int[] partion(int[] arr, int begin, int end) {
        int pivot = arr[begin], less = begin - 1, greater = end + 1, cur = begin;
        while (cur < greater) {
            if (arr[cur] < pivot) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --greater);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, greater - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
