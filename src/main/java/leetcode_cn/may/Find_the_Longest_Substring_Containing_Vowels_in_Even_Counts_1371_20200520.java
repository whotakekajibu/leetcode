package leetcode_cn.may;

import java.util.Arrays;

/**
 * @Description
 * @Date 2020/5/20 22:01
 **/
public class Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts_1371_20200520 {
    public static void main(String[] args) {
//        String s = "leetcodeisgreat";
        String s = "yopumzgd";
        System.out.println(findTheLongestSubstring(s));
    }
    //aeiou
    public static int findTheLongestSubstring(String s) {
        int[] memo = new int[1 << 5];
        Arrays.fill(memo,-2);
        memo[0] = -1;
        int ans = 0, status = 0;
        for(int i = 0; i < s.length(); i++){
            status ^= get(s.charAt(i));
            if(memo[status] == -2){
                memo[status] = i;
            }else{
                ans = Math.max(ans,i - memo[status]);
            }
        }
        return ans;
    }
    public static int get(char c){
        switch(c){
            case 'a':{
                return 1 << 0;
            }
            case 'e':{
                return 1 << 1;
            }
            case 'i':{
                return 1 << 2;
            }
            case 'o':{
                return 1 << 3;
            }
            case 'u':{
                return 1 << 4;
            }
            default :
                return 0;
        }

    }
}
