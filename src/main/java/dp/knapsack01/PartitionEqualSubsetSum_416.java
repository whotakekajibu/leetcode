package dp.knapsack01;

public class PartitionEqualSubsetSum_416 {
    public static void main(String[] args) {
//        int[] arr = {2, 2, 3, 5};
//        System.out.println(canPartition(arr));

    }




    static int[][] m;

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 1) return false;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;
        sum /= 2;
        m = new int[nums.length][sum + 1];
        return cal(nums, 0, sum);
    }

    static boolean cal(int[] nums, int idx, int target) {
        if (idx == nums.length) {
            return 0 == target;
        }
        if (m[idx][target] != 0) return m[idx][target] == 1;

        boolean nottaken = cal(nums, idx + 1, target);
        if (nottaken) {
            m[idx][target] = 1;
            return true;
        }
        boolean taken = false;
        if (target - nums[idx] >= 0) {
            taken = cal(nums, idx + 1, target - nums[idx]);
            m[idx][target] = taken ? 1 : -1;
        }
        return taken;
    }
}
