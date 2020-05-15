package Array.monostack.Trapping_Rain_Water_42;

/**
 * @Description
 * @Date 2020/4/1 8:14
 **/
public class Trapping_Rain_Water_with_dp_42 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    public static int trap(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return 0;
        }
        //left to right [0-i]max value
        int[] towards = new int[arr.length];
        towards[0] = arr[0];
        //right to left [i-arr.length - 1]max value
        int[] backwards = new int[arr.length];
        backwards[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            towards[i] = arr[i] > towards[i - 1] ? arr[i] : towards[i - 1];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            backwards[i] = arr[i] > backwards[i + 1] ? arr[i] : backwards[i + 1];
        }
        int ans = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int l = towards[i];
            int r = backwards[i];
            ans += Math.min(l,r) - arr[i];
        }
        return ans;
    }
}
