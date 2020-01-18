package dp;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/1/14 11:52
 **/
public class Minimum_Distance_to_Type_a_Word_Using_Two_Fingers_1320 {

    static Pair[] map = new Pair[26];
    static Map<String, Integer> m = new HashMap<>();

    public static void main(String[] args) {
        char startCharacter = 'A';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6 && startCharacter <= 'Z'; j++) {
                map[startCharacter - 'A'] = new Pair(i, j);
                startCharacter++;
            }
            if (startCharacter > 'Z') {
                break;
            }
        }
        System.out.println(minimumDistance_memo("HAPPY"));
    }

    ////////////////////////////////////////////memoization////////////////////////////////////////////////////
    public static int minimumDistance_memo(String word) {
        m.clear();
        return helper(word, '$', '$', 0);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static int getDistance(Pair pair1, Pair pair2) {
        if (pair1 == null || pair2 == null) {
            return 0;
        }
        return Math.abs(pair1.getX() - pair2.getX()) + Math.abs(pair1.getY() - pair2.getY());
    }

    public static Pair getPair(char c) {
        if (c == '$') {
            return null;
        }
        return map[c - 'A'];
    }


    public static int helper(String word, char left, char right, int idx) {
        if (idx == word.length()) {
            return 0;
        }
        String key = left + "_" + right + "_" + idx;
        if (m.containsKey(key)) {
            return m.get(key);
        }
        Pair curPair = getPair(word.charAt(idx));
        Pair leftPair = getPair(left);
        Pair rightPair = getPair(right);
        //using left finger first
        int leftCos = helper(word, word.charAt(idx), right, idx + 1) + getDistance(leftPair, curPair);
        //using right finger first
        int rightCos = helper(word, left, word.charAt(idx), idx + 1) + getDistance(rightPair, curPair);
        int res = Math.min(leftCos, rightCos);
        m.put(key, res);
        return res;
    }
/*
    public static int helper(String word, char leftChar, char rightChar, boolean left, int idx) {
        if (idx == word.length()) {
            return 0;
        }
        Pair curPair = getPair(word.charAt(idx));
        int curDistance;
        if (left) {
            Pair leftPair = getPair(leftChar);
            curDistance = getDistance(curPair, leftPair);
        } else {
            Pair rightPair = getPair(rightChar);
            curDistance = getDistance(curPair, rightPair);
        }
        return curDistance + Math.min(helper(word, word.charAt(idx), rightChar, true, idx + 1), helper(word, leftChar, word.charAt(idx), idx + 1));
    }*/

    ////////////////////////////////////////////memoization////////////////////////////////////////////////////


    ////////////////////////////////////////////dp////////////////////////////////////////////////////
    public static int minimumDistance_dp(String word) {
        //TODO
        return 0;
    }
    ////////////////////////////////////////////dp////////////////////////////////////////////////////
}
