package leetcode_cn.april;


/**
 * @Description
 * @Date 2020/4/10 10:04
 **/
public class Flip_Words_151_20200410 {
    public static void main(String[] args) {
//        String s = "the sky   is blue ";
//        String s = "i love  you  ";
//        String s = "   a    bg        ";
//        String s = "the sky is blue";
        String s = "e ";
        String s1 = reverseWords(s);
        System.out.println(s1);
        System.out.println(s1.length());
    }

    /**
     * the sky   is blue
     */
    public static String reverseWords(String s) {
        s = s.trim();
        if (s.length() < 1) {
            return "";
        }
        s = " " + s;
        char[] chars = s.toCharArray();
        int r = chars.length - 1;
        while (r > 0) {
            int l = 0;
            while (l < r && chars[l] == ' ' && chars[l + 1] == ' ') {
                l++;
            }
            if (l == r) {
                break;
            }
            int start = l;
            l++;
            while (l < r && chars[l] != ' ') {
                l++;
            }
            if (l == r) {
                break;
            }
            moveKthRightToLeft(chars, start, r, l - start);
            r -= l - start;
        }
        int i = 0;
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }
        return new String(chars).substring(i);
    }

    public static void moveKthRightToLeft(char[] chars, int start, int end, int k) {
        int len = end - start + 1;
        if (len == k) {
            return;
        }
        reverse(chars, start, end);
        reverse(chars, start, start + len - k - 1);
        reverse(chars, start + len - k, end);
        System.out.println(new String(chars));
    }

    public static void reverse(char[] src, int i, int j) {
        while (i < j) {
            char tmp = src[i];
            src[i] = src[j];
            src[j] = tmp;
            i++;
            j--;
        }
    }
}
