package Array;

public class First_Missing_Positive_41 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1};
//        int[] arr = {7,8,4,11,12};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;          //case: nums == null or nums == [], return 1
        for (int i = 0; i < nums.length; i++) {                     //use nums array itself, the ideal array should be {1,2,3,4}
            int curr = nums[i];                                 //swap if nums[index] != index + 1;
            while (curr - 1 >= 0 && curr - 1 < nums.length && curr != nums[curr - 1]) {
                int next = nums[curr - 1];
                nums[curr - 1] = curr;
                curr = next;
            }
        }
        for (int i = 0; i < nums.length; i++) {                      //check if nums[index] == index + 1;
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}