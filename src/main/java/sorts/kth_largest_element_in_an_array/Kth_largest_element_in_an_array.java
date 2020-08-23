package sorts.kth_largest_element_in_an_array;

/**
 * @Description
 * @Date 2020/7/1 19:49
 **/
public class Kth_largest_element_in_an_array {
    public int findKthLargest(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        while (true) {
            int idx = partition(nums, i, j);
            if (idx == nums.length - k) {
                return nums[idx];
            }
        }
    }

    public int partition(int[] arr, int i, int j) {
        int mid = (i + j) / 2;
        int pivot = arr[mid];
        int less = i, more = j;
        while (less <= more) {
            if (arr[less] <= pivot) {
                less++;
            } else {
                swap(arr, less, more--);
            }
        }
        return 0;
    }

    public void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
