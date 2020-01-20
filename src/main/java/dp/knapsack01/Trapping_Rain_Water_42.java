package dp.knapsack01;

public class Trapping_Rain_Water_42 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
    public static int trap(int[] height) {
        return 0;
    }
    public int helper(int[] arr,int idx,int leftBound,int curRes){
        if (idx == arr.length){
            return curRes;
        }
        return 0;
    }

}
