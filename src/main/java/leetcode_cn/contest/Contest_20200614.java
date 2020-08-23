package leetcode_cn.contest;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Date 2020/6/14 10:32
 **/
public class Contest_20200614 {
    public static void main(String[] args) {
        Map m = null;
        Set set = m.keySet();

        m.values();
    }
    public static int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return sum;
    }
}
