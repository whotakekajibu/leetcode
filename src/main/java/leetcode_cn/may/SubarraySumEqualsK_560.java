package leetcode_cn.may;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2020/5/15 19:34
 **/
public class SubarraySumEqualsK_560 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(arr, k));
    }

    public static int subarraySumRecur(int[] arr, int k) {
        return helper(arr, arr.length - 1, k);
    }

    public static int subarraySum(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int ans = 0;
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
            if (map.containsKey(prefix[i + 1] - k)) {
                int cur = map.get(prefix[i + 1] - k);
                map.put(prefix[i + 1], cur + 1);
                ans = cur + 1;
            } else {
                map.put(prefix[i + 1], 0);
            }
        }
        return ans;
    }

    //end with idx subarray sum equals to ka
    public static int helper(int[] arr, int idx, int k) {
        if (k == 0) {
            return 1;
        }
        if (idx == 0) {
            if (arr[idx] == k) {
                return 1;
            } else {
                return 0;
            }
        }
        int ans = 0;
        for (int i = idx; i >= 0; i--) {
            ans += helper(arr, i, k - arr[i]);
        }
        return ans;
    }
}
