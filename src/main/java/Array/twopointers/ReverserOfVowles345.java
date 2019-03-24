package Array.twopointers;

public class ReverserOfVowles345 {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
    public static String reverseVowels(String s) {
        int l = 0,r = s.length()-1;
        char[] chars = s.toCharArray();
        while(l < r){
            while(l < r && !isVoewl(chars[l])){
                l++;
            }while(l< r && !isVoewl(chars[r])){
                r--;
            }
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;

        }
        return new String(chars);
    }
    static boolean isVoewl(char c){
        return c=='a' || c== 'e' || c== 'i' || c=='o' || c== 'u';
    }
}
