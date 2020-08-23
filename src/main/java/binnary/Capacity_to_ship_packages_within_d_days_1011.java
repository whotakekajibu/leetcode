package binnary;

/**
 * @Description
 * @Date 2020/6/25 15:57
 **/
public class Capacity_to_ship_packages_within_d_days_1011 {


    public static int shipWithinDays(int[] arr, int d) {
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        int maxVal = -1;
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
            maxVal = Math.max(maxVal, arr[i]);
        }
        int l = maxVal, r = preSum[preSum.length - 1];
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            //least weight capacity
            int mid = (l + r) / 2;
            boolean can = inDdays(arr, mid, d);
            if (can) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {488,247,151,268,358,270,366,2,85,49,209,37,353,17,287,385,421,467,32,201,398,27,108,291,435,447};
        int d = 26;//
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int d = 5;
        System.out.println(shipWithinDays(arr, d));
//        System.out.println(inDdays(arr, 467, d));
    }

    static boolean inDdays(int[] arr, int capacity, int d) {
        int cap = 0;
        for (int e : arr) {
            if (capacity < e){
                return false;
            }
            if (cap + e > capacity){
                cap = e;
                d--;
            }else {
                cap += e;
            }
            if (d <= 0){
                return false;
            }
        }
        return true;
    }
}
