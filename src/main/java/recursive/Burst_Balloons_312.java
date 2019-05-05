package recursive;

public class Burst_Balloons_312 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        System.out.println(maxCoins(arr));
    }

    public static int maxCoins(int[] nums) {
        int len = nums.length;
        int[] p = new int[len + 2];
        p[0] = 1;
        p[len + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            p[i] = nums[i - 1];
        }
        return maxCoins(p, 1, len);
//        return 0;
    }

    public static int maxCoins(int[] arr, int begin, int end) {
//        "".toCharArray()
//        if (begin == end)
//            return arr[begin];
        if (begin > end)
            return 0;
        int ans = 0;
        for (int cur = begin; cur <= end; cur++) {
            int left = maxCoins(arr, begin, cur - 1);
            int mid = arr[begin - 1] * arr[cur] * arr[end + 1];
            int right = maxCoins(arr, cur + 1, end);
            ans = Math.max(ans, left + mid + right);
        }
        return ans;
    }


}
