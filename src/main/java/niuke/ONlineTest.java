package niuke;

import Utils.MathUtils;
import Utils.Utils;
import netscape.security.UserTarget;

import java.util.*;

/**
 * @Description
 * @Date 2020/8/1 19:29
 **/
public class ONlineTest {
    /**
     * while(in.hasNext()) {
     * int a = in.nextInt();
     * int b = in.nextInt();
     * System.out.println(a + b);
     * in.nextLine();
     * }
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strArr = s.split(",");
        int[] arr = new int[strArr.length];
        // {1, 2, 5, 4, 4, 5, 2, 1}
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.valueOf(strArr[i]);
        }
        int[][] group = group(arr);
        if (group.length == 0) {
            System.out.println("[]");
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < group.length; i++) {
            int[] oneD = group[i];
            sb.append("[");
            for (int k = 0; k < oneD.length; k++) {
                sb.append(oneD[k]);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static int[][] group(int[] students) {
        Arrays.sort(students);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < students.length; i++) {
            if (map.containsKey(students[i])) {
                Integer curCnt = map.get(students[i]) + 1;
                map.put(students[i], curCnt);
            } else {
                map.put(students[i], 1);
            }
        }
        int minLen = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            minLen = Math.min(minLen, value);
        }
        for (Integer value : map.values()) {
            if (value % minLen != 0) {
                return new int[][]{{}};
            }
        }
        int width = minLen;
        int[][] ans = new int[students.length / width][width];
        for (int m = 0; m < students.length / width; m++) {
            int[] an = ans[m];
            for (int n = 0; n < width; n++) {
                an[n] = students[m * width + n];
            }
        }
        return ans;
    }
}
