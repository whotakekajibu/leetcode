package permutation;

/**
 * @Description
 * @Date 2020/6/11 23:23
 **/
public class Next_Permutation_31 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                while (nums[i - 1] >= nums[last]) {
                    last--;
                }
                swap(nums, i - 1, last);
                reverse(nums, i, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, last);
    }

    static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    static void swap(int[] nums, int i, int j) {
        if (i >= j || i < 0 || j >= nums.length) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
