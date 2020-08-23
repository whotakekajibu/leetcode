package binnary;

/**
 * @Description
 * @Date 2020/6/22 11:40
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 2, 3,4};
        int target = 1;
        System.out.println(binarySearchLast(arr, target));
    }

    //如果数组种存在，则返回其最后出现的索引位置，如果不存在返回-1
    public static int binarySearchLast(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int midVal = arr[mid];
            if (midVal <= target) {
                l = mid + 1;
            } else if (midVal > target) {
                r = mid - 1;
            }
        }
        return l == arr.length ? -1 : (l == 0 ? 0 : l - 1);
    }
}
