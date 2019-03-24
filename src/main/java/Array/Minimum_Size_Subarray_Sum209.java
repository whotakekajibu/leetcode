package Array;

public class Minimum_Size_Subarray_Sum209 {
    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println(minSubArrayLen(3,arr));
    }
    //nums[l...r]
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0,r = -1,sum = 0, res = nums.length;
        while(l < nums.length){
//            if(r == l) break;
            while( r < nums.length-1 && sum < s){
                sum += nums[++r];
            }
            res = Math.min(res,r - l + 1);
            while(l <= r && sum >= s){
                sum -= nums[l++];
            }
            res = Math.min(res,r-l+2);
            if (r == nums.length - 1){
                break;
            }
        }
        if (l == 0 && r == nums.length - 1)
            res = 0;
        return res;
    }
}
