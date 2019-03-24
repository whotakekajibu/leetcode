package Array.twopointers.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = 3 ^ 'b' ^ 'a';
        System.out.println(i);
        Map<String,Integer> m1 = new HashMap<>();
        m1.put("b",2);
        m1.put("a",1);
        Map<String,Integer> m2 = new HashMap<>();
        m2.put("a",1);
        m2.put("b",2);
        System.out.println(m1.equals(m2));
//        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println(lengthOfLongestSubstringRefactor(s));
    }
    //哈希表的自己想到的，(sliding window)
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character,Integer> maps = new HashMap<>(s.length());
        int l = 0,r = -1,tmp,res = -1;
        char[] chars = s.toCharArray();
        while(l < chars.length){
            if(r < chars.length - 1 && !maps.containsKey(chars[++r])){
                maps.put(chars[r],r);
                res = Math.max(res,r-l+1);
            }else{
                tmp = maps.get(chars[r]);
                while(l <= tmp){
                    maps.remove(chars[l]);
                    l++;
                }
                maps.put(chars[r],r);
            }
        }
        return res;
    }
    //视频课程中的(sliding window)
    public static int lengthOfLongestSubstringRefactor(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] asc = new int[256];
        char[] chars = s.toCharArray();
        int l = 0,r = -1,res = 0;
        while(l < chars.length){
            if (r < chars.length-1 && asc[chars[r+1]] == 0 ){
                r++;
                asc[chars[r]]++;
            }else {
                asc[chars[l]]--;
                l++;
            }
            res = Math.max(res,r - l + 1);
        }
        return res;
    }
}
