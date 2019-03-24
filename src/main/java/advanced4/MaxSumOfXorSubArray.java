package advanced4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxSumOfXorSubArray {

    public static void main(String[] args) {

        Queue<String> q = new LinkedList<>();
        int a = 1,b=2;
        double  d = ((double)a+(double)b)/2;
        System.out.println(d);
    }
    public static int maxSumOfXorSubArray(int[] arr) {
        Map<Integer, Integer> maps = new HashMap<>();
        maps.put(0, -1);
        int ans = 0;
        int xor = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (maps.containsKey(xor)) {
                int pre = maps.get(xor);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            maps.put(xor, i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
