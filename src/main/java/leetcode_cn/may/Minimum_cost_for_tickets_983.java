package leetcode_cn.may;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/5/7 23:02
 **/
public class Minimum_cost_for_tickets_983 {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
    }

    /**
     * dp[k] = k
     *
     * @param days
     * @param costs
     * @return
     */
    public static int mincostTickets(int[] days, int[] costs) {
        return hepler(days, days.length - 1, costs);
    }

    public static int hepler(int[] days, int i, int[] costs) {
        if (i < 0) {
            return 0;
        }
        if (i < 3) {
            return (i + 1) * costs[0];
        }
        if (i < 7 && days[i] - days[0] <= 7) {
            return costs[1];
        }
        if (i < 30 && days[i] - days[0] <= 30) {
            return costs[2];
        }
        int buy1 = hepler(days, i - 1, costs) + costs[0];
        int buy7 = hepler(days, i - 7, costs) + costs[1];
        int buy30 = hepler(days, i - 30, costs) + costs[2];
        return min(buy1, buy7, buy30);
    }

    static int min(int... arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (ans < arr[i]) {
                ans = arr[i];
            }
        }
        return ans;
    }
}
