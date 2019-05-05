package recursive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Longest_Palindromic_Substring_5 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(longestPalindromeSubseq("kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd"));
        System.out.println(longestPalindromeSubseq("daomdukomcayjwgmmetypncdeixarhbectjcwftjjtwjrctixtrsehegwlfotpljeeqhntacfihecdjysgfmxxbjfeskvvfqdoedfxriujnoeteleftsjgdsagqvcgcdjbxgmguunhbjxyajutohgbdwqtjghdftpvidkbftqbpeahxbfyamonazvubzirhqseetaneptnpjbtrtitttxsyjckjvwtrmuwgidkofvobrwrffzrpnxbectsydbvswstfiqranjzhsebjnmprjoirqkgttahrivkcjtitdcpohwwerwgrdivqbltfnigavydxpmitttjjzyrmpaptkczzgnsovebvxezkkovgqegctxacvjfqwtiycnhartzczcgosiquhmdbljjzyrnmffcwnkyzytnsvyzayrieqyrfpxintbbiyrawxlguzaisedwabpzvevlejadztuclcpwvonehkhknicdksdcnjfaoeaqhcdkdtywilwewadcnaprcasccdcnvdgjdqirrsqwzhqqorlhbgpelpupdvuynzybcqkffnnpocidkkigimsa"));
        System.out.println(System.currentTimeMillis() - start);

//        System.out.println(longestPalindromeSubseq("babadada"));
//        System.out.println(longestPalindromeSubseq("cdeedfeyueyryew"));
    }

    public static String longestPalindromeSubseq(String s) {
        String res = helper(s.toCharArray(), 0, s.length() - 1);
        return res;
    }

    static Map<String, String> m = new HashMap<>();

    static String helper(char[] chars, int i, int j) {
        String key = i + "_" + j;
        if (m.containsKey(key)) return m.get(key);
        String res = "";
        if (i > j) {
            m.put(key, res);
            return res;
        }
        if (i == j) {
            res = new String(chars, i, 1);
            m.put(key, res);
            return res;
        }
        if (chars[i] == chars[j]) {
            if (i + 1 == j) {
                res = new String(chars, i, 2);
                m.put(key, res);
                return res;
            }
            if (i + 2 == j) {
                res = new String(chars, i, 3);
                m.put(key, res);
                return res;
            }
            res = helper(chars, i + 1, j - 1);
            if (res.length() == j - i - 1) {
                res = chars[i] + res + chars[j];
                m.put(key, res);
                return res;
            }
        }
        String left = helper(chars, i + 1, j);
        String right = helper(chars, i, j - 1);
        if (res.length() < left.length()) {
            res = left;
        }
        if (res.length() < right.length()) {
            res = right;
        }
        m.put(key, res);
        return res;
    }

}
