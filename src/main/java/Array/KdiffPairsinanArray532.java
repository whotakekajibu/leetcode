package Array;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsinanArray532 {
    public static void main(String[] args) {

    }
    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k) || map.containsKey(nums[i] + k)) {
                int val = 0;
                if (map.get(nums[i] - k) != null) {
                    val = map.get(nums[i] - k);
                    if (nums[i] == nums[val]) {
                        continue;
                    }
                }
                if (map.get(nums[i] + k) != null) {
                    val = map.get(nums[i] + k);
                    if (nums[i] == nums[val]) {
                        continue;
                    }
                }
                ans++;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
