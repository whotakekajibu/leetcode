package string;

public class Reverse_Words_InString_151 {
    public static void main(String[] args) {
        String str = "  hello world!  ";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] da = new char[s.length() + 1];
        int idx = helper(s.toCharArray(), s.length() - 1, da, 0);
        while (da[idx] == ' ') {
            idx--;
        }
        return new String(da, 0, idx + 1);
    }

    static int helper(char[] ch, int i, char[] res, int cur) {
        //suffix find first not space charactr
        while (i >= 0 && ch[i] == ' ') {
            i--;
        }
        //if all character is space then return
        if (i < 0) {
            return cur;
        }
        int t = i;
        while (t >= 0 && ch[t] != ' ') {
            t--;
        }
        //t point the first space next to a word
        if (t == -1) {
            // t point the last word ,so there're no space left
            copy(ch, 0, i, res, cur);
            return cur + i + 1;
        }
        //t+1 point the first character of the word,and i point the last
        copy(ch, t + 1, i, res, cur);

        return helper(ch, t - 1, res, cur + i - t + 1);

    }

    static void copy(char[] sa, int i, int j, char[] da, int s) {
        while (i <= j) {
            da[s] = sa[i];
            s++;
            i++;
        }
        da[s] = ' ';
    }
}
