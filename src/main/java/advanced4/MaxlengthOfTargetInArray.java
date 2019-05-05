package advanced4;

import java.util.HashMap;
import java.util.Map;

public class MaxlengthOfTargetInArray {
    public static void main(String[] args) {
//        int[] arr = {7, 3, 2, 1, 1, 7, -1, -6, -7};
//        System.out.println(maxLength(arr, 7));
        int a = 1;
        int b = 0;
        b += a > 0 ? a : 0;
        System.out.println(b);
    }

    public static int maxLength(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int diff = sum - target;
            if (!map.containsKey(diff)) {
                map.put(sum, i);
            } else {
                int idx = map.get(diff);
                res = Math.max(res, i - idx);
            }
        }
        return res;
    }

}
