package Array.twopointers;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
    public static int maxArea(int[] height) {
        int res = 0,l = 0, r = height.length - 1;
        while(l < r){
            int h = Math.min(height[l],height[r]);
            res = Math.max(res,h * (r - l));
            if(height[l] >= height[r]){
                r--;
            }else{
                l++;
            }
        }
        return res;
    }
}
