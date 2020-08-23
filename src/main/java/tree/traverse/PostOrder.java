package tree.traverse;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Date 2020/6/7 18:35
 **/
public class PostOrder {
    //-4,-1,1,2
    public static void main(String[] args) {
        int[] nums = {-1,1,1};
        System.out.println(threeSumClosest(nums,1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < nums.length - 2; i ++){
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            int d = target - nums[i];
            int l = i + 1,r = nums.length - 1;
            while(l < r){
                int acc = nums[l] + nums[r];
                if(acc == d){
                    return target;
                }else if (acc > d){
                    r--;
                }else {
                    l++;
                }
                int abs = Math.abs(acc - d);
                if( abs < delta ){
                    delta  = abs;
                    ans = acc + nums[i];
                }
            }
        }
        return ans;
    }
}
