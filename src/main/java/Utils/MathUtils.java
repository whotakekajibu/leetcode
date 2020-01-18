package Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 大数相乘，相加
 * @Date 2019/10/20 18:46
 **/
public class MathUtils {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(add("193", "456"));
    }

    public static String add(String... strings) {
        int[] first = convertStringArrayToIntArray(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            int[] second = convertStringArrayToIntArray(strings[i]);
            first = addTwoIntArray(first, second);
        }
        return convertIntArrayToStringArray(first);
    }

    //tmmzuxt
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = 0;
        while (r < chars.length) {
            if (map.containsKey(chars[r]) && map.get(chars[r]) >= l) {
                l = map.get(chars[r]) + 1;
                r++;
                continue;
            }
            map.put(chars[r], r);
            max = Math.max(r - l + 1, max);
            r++;
        }
        return max;
    }

    public static int[] convertStringArrayToIntArray(String str) {
        int[] res = new int[str.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = Character.getNumericValue(str.charAt(i));
        }
        return res;
    }

    public static String convertIntArrayToStringArray(int[] intArr) {
        StringBuilder sb = new StringBuilder(intArr.length);
        for (int i : intArr) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static int[] addTwoIntArray(int[] first, int[] second) {
        int res;
        boolean firstLen = true;
        if (first.length < second.length) {
            firstLen = false;
            res = addTwoIntArrayHelper(second, second.length - 1, first, first.length - 1, 0);
        } else {
            res = addTwoIntArrayHelper(first, first.length - 1, second, second.length - 1, 0);
        }
        if (res == 1) {
            int[] arr;
            if (firstLen) {
                arr = new int[first.length + 1];
                copyFromEnd(first, arr);
            } else {
                arr = new int[second.length + 1];
                copyFromEnd(second, arr);
            }
            arr[0] = 1;
            return arr;
        }
        if (firstLen) {
            return first;
        } else {
            return second;
        }
    }

    public static int addTwoIntArrayHelper(int[] first, int f, int[] second, int s, int carryBit) {
        if (s < 0) {
            if (f < 0) {
                return carryBit;
            }
            int sum = first[f] + carryBit;
            if (sum > 9) {
                first[f] = sum - 10;
                return addTwoIntArrayHelper(first, --f, second, s, 1);
            } else {
                first[f] = sum;
                return 0;
            }
        }
        int sum = first[f] + second[s] + carryBit;
        if (sum > 9) {
            first[f] = sum - 10;
            return addTwoIntArrayHelper(first, --f, second, --s, 1);
        } else {
            first[f] = sum;
            return addTwoIntArrayHelper(first, --f, second, --s, 0);
        }
    }

    public static void copyFromEnd(int[] from, int[] to) {
        int fromLen = from.length;
        for (int i = fromLen - 1; i >= 0; i--) {
            to[i + 1] = from[i];
        }
    }


}
