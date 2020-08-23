package recursive;

/**
 * @Description
 * @Date 2020/1/12 0:03
 **/
public class Decrypt_String_from_Alphabet_to_Integer_Mapping_1309 {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

    public static char map(String s) {
        if (s.endsWith("#")) {
            s = s.substring(0, s.length() - 1);
            return (char) (Integer.valueOf(s) + 96);
        }
        return (char) (Integer.valueOf(s) + 96);
    }

    /**
     * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
     * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
     * <p>
     * Input: s = "10#11#12"
     * Output: "jkab"
     * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
     *
     * @param s
     * @return
     */
    public static String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() > 0) {
            helper(s, sb, s.length() - 1);
        }
        return sb.toString();
    }

    public static void helper(String s, StringBuilder sb, int idx) {
        if (idx < 0) {
            return;
        }
        if (s.charAt(idx) == '#') {
            String end = s.substring(idx - 2);
            sb.insert(0, map(end));
            s = s.substring(0, idx - 2);
            helper(s, sb, idx - 3);
        } else {
            String end = s.substring(idx);
            sb.insert(0, map(end));
            s = s.substring(0, idx);
            helper(s, sb, idx - 1);
        }
    }
}
