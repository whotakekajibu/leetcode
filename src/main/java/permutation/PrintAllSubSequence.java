package permutation;

public class PrintAllSubSequence {

    public static void main(String[] args) {
        char[] ch = "abc".toCharArray();
        printAllSubsequence(ch);
//        printAllSubsequence(ch,0,"");
    }
    private static void printAllSubsequence(char[] ch, int i, String s) {
        if (i == ch.length) {
            System.out.println(s);
            return;
        }
        printAllSubsequence(ch, i + 1, s);
        printAllSubsequence(ch, i + 1, s + ch[i]);
    }
    private static void printAllSubsequence(char[] ch){
        int cnt = (int) Math.pow(2,ch.length);
        for (int i = 0; i < cnt; i++) {
            String res = "";
            int t = i,idx = 0;
            while (t != 0){
                if((t & 1) == 1){
                    res += ch[idx];
                }else {
//                    res += " ";
                }
                idx++;
                t = t >> 1;
            }
            System.out.println(res);
        }
    }
}
