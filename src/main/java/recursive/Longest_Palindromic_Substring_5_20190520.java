package recursive;

import java.util.Arrays;


public class Longest_Palindromic_Substring_5_20190520 {


    public static String longestPalindrome(String s) {
        int[] len = new int[1];
        int[] start = new int[1];
        int[][] memo = new int[s.length()][s.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        helper(s.toCharArray(), 0, s.length() - 1, len, start, memo);
        return s.substring(start[0], start[0] + len[0]);
    }

    /**
     * Runtime: 128 ms, faster than 17.62% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 49 MB, less than 6.47% of Java online submissions for Longest Palindromic Substring.
     * <p>
     * POOR PERFORMANCE
     */
    static boolean helper(char[] ch, int i, int j, int[] len, int[] start, int[][] memo) {
        if (i > j) return false;
        if (memo[i][j] != -1) return memo[i][j] == 1;
        if (i == j) {
            if (len[0] < 1) {
                len[0] = 1;
                start[0] = i;
            }
            memo[i][j] = 1;
            return true;
        } else {
            if (ch[i] == ch[j]) {
                if (j - i == 1 || j - i == 2) {
                    if (j - i + 1 > len[0]) {
                        start[0] = i;
                        len[0] = j - i + 1;
                    }
                    memo[i][j] = 1;
                    return true;
                }
                if (helper(ch, i + 1, j - 1, len, start, memo)) {
                    if (len[0] < j - i + 1) {
                        start[0] = i;
                        len[0] = j - i + 1;
                    }
                    memo[i][j] = 1;
                    return true;
                }
            }
            if (helper(ch, i + 1, j, len, start, memo)) {
                if (j - i > len[0]) {
                    start[0] = i + 1;
                    len[0] = j - i;
                }
            }
            if (helper(ch, i, j - 1, len, start, memo)) {
                if (j - i > len[0]) {
                    start[0] = i;
                    len[0] = j - i;
                }
            }
            memo[i][j] = 0;
            return false;
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    public static String longestPalindromeDP(String s) {
        int len = s.length();
        int[] dp = new int[len];
        return null;
    }



    public static void main(String[] args) {
//        String s = "daomdukomcayjwgmmetypncdeixarhbectjcwftjjtwjrctixtrsehegwlfotpljeeqhntacfihecdjysgfmxxbjfeskvvfqdoedfxriujnoeteleftsjgdsagqvcgcdjbxgmguunhbjxyajutohgbdwqtjghdftpvidkbftqbpeahxbfyamonazvubzirhqseetaneptnpjbtrtitttxsyjckjvwtrmuwgidkofvobrwrffzrpnxbectsydbvswstfiqranjzhsebjnmprjoirqkgttahrivkcjtitdcpohwwerwgrdivqbltfnigavydxpmitttjjzyrmpaptkczzgnsovebvxezkkovgqegctxacvjfqwtiycnhartzczcgosiquhmdbljjzyrnmffcwnkyzytnsvyzayrieqyrfpxintbbiyrawxlguzaisedwabpzvevlejadztuclcpwvonehkhknicdksdcnjfaoeaqhcdkdtywilwewadcnaprcasccdcnvdgjdqirrsqwzhqqorlhbgpelpupdvuynzybcqkffnnpocidkkigimsa";
        String s = "mttt";

    }
}
