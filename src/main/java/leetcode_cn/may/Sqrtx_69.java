package leetcode_cn.may;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/5/9 7:47
 **/
public class Sqrtx_69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(100));
        System.out.println(mySqrt(154, 0.01));
    }

    public static int mySqrt(int x) {
        int l = 0, r = x;
        int ans = 0;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static double mySqrt(int x, double accuracy) {
        double l = 0, r = x;
        double mid = (r + l) / 2;
        double ans = mid;
        while (Math.abs(mid * mid - x) >= accuracy) {
            mid = (r + l) / 2;
            double m = mid * mid;
            if (m == x) {
                return mid;
            } else if (m < x) {
                l = mid;
            } else {
                r = mid;
            }
            ans = mid;
        }
        long round = Math.round(ans);
        if (round * round == x) {
            return round;
        }
        return ans;
    }
}
