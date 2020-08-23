package leetcode_cn.contest;

import java.util.*;

/**
 * @Description
 * @Date 2020/5/17 10:34
 **/
public class Contest_20200517 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"),
                Arrays.asList("google", "facebook"),
                Arrays.asList("google"),
                Arrays.asList("amazon"));
        System.out.println(peopleIndexes(favoriteCompanies));

    }

    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<Integer, Set<String>> map = new HashMap<>(favoriteCompanies.size());
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            map.put(i, new HashSet<>(favoriteCompanies.get(i)));
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean subset = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (j == i) {
                    continue;
                }
                if (favoriteCompanies.get(j).containsAll(favoriteCompanies.get(i))) {
                    subset = true;
                    break;
                }
            }
            if (!subset) {
                ans.add(i);
            }
        }

        return ans;
    }


}
