package leetcode_cn.april;

/**
 * @Description
 * @Date 2020/5/6 22:29
 **/
public class Reverse_pairs_in_arr_51  {
    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        System.out.println(reversePairs(arr));
    }


    public static int reversePairs(int[] arr) {
        ans = 0;
        mergeSort(arr, 0, arr.length - 1);
        return ans;
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    static int ans;

    public static void merge(int[] arr, int l, int m, int r) {
        int[] copy = new int[r - l + 1];
        int idx = 0, dm = m + 1, dl = l;
        while (l <= m && dm <= r) {
            if (arr[l] > arr[dm]) {
                copy[idx] = arr[dm];
                dm++;
                ans += m - l + 1;
            } else {
                copy[idx] = arr[l];
                l++;
            }
            idx++;
        }
        if (l - 1 == m) {
            while (dm <= r) {
                copy[idx++] = arr[dm++];
            }
        } else if (dm - 1 == r) {
            while (l <= m) {
                copy[idx++] = arr[l++];
            }
        }
        for (int i = 0; i < copy.length; i++) {
            arr[i + dl] = copy[i];
        }
    }
}
