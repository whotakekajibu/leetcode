package leetcode_cn.april;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/4/27 22:24
 **/
public class Search_in_rotated_sorted_array_33 {
    public static void main(String[] args) {
//        int[] arr = {4, 5, 6, 7, 0, 1, 2};
//        int[] arr = {5, 6, 1, 2, 3, 4};
//        int[] arr = {8, 9, 2, 3, 4};
//        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr = {1,3};
        System.out.println(search(arr, 0));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] arr, int i, int j, int target) {
        if (i > j) {
            return -1;
        }
        if (i == j) {
            if (arr[i] == target) {
                return i;
            }
            return -1;
        }
        if (arr[i] == target) {
            return i;
        }
        if (arr[j] == target) {
            return j;
        }
        int mid = (i + j) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[i] < arr[mid - 1]) {
            if (arr[i] < target && target < arr[mid - 1]) {
                return binarySearch(arr, i + 1, mid - 1, target);
            } else {
                return binarySearch(arr, mid + 1, j - 1, target);
            }
        }
        if (arr[mid + 1] < arr[j]) {
            if ((arr[mid] > target || target > arr[j])) {
                return binarySearch(arr, mid + 1, j - 1, target);
            } else {
                return binarySearch(arr, i + 1, mid - 1, target);
            }
        }
        return -1;
    }
}
