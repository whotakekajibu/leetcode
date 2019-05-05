package dp;

import java.util.HashMap;
import java.util.Map;

//https://youtu.be/yRpp-D7NlOQ?t=4156
public class House_robber_NEW_METHOD_198 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        m.clear();
        return helper(nums, nums.length - 1, true);
    }

    static Map<String, Integer> m = new HashMap<>();

    static int helper(int[] arr, int i, boolean choosen) {
        if (i == 0) {
            if (choosen)
                return arr[i];
            return 0;
        }
        String key = i + "_" + choosen;
        if (m.containsKey(key)) return m.get(key);
        int taken = 0, nottaken;
        if (choosen) {
            taken = arr[i] + helper(arr, i - 1, false);
            nottaken = helper(arr, i - 1, true);
        } else {
            nottaken = helper(arr, i - 1, true);
        }
        int res = Math.max(taken, nottaken);
        m.put(key, res);
        return res;
    }
}
