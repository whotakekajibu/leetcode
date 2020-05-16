package leetcode_cn.contest;

import java.util.*;

/**
 * @Description
 * @Author ericning@wezhuiyi.com
 * @Date 2020/5/15 20:40
 **/
public class MinimumTimeToCollectAllApplesIATree {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
//        List<Boolean> hasApple = Arrays.asList(false, false, true, false, false, true, false);
        System.out.println(minTime(7, edges, hasApple));
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int[] edge : edges) {
            if (m.containsKey(edge[0])) {
                List<Integer> ls = m.get(edge[0]);
                ls.add(edge[1]);
            } else {
                List<Integer> ls = new ArrayList<>();
                ls.add(edge[1]);
                m.put(edge[0], ls);
            }
        }
        int ans = 0;
        for (Integer i : m.get(0)) {
            ans += helper(i, m, hasApple);
        }
        return ans;
    }

    public static int helper(int startNode, Map<Integer, List<Integer>> m, List<Boolean> apple) {
        if (!m.containsKey(startNode)) {
            //叶子节点
            if (apple.get(startNode)) {
                return 2;
            }
            return 0;
        }
        List<Integer> twoNodes = m.get(startNode);
        int ans = 0;
        if (apple.get(startNode)) {
            ans += 2;
            //当前节点有苹果
            for (Integer i : twoNodes) {
                ans += helper(i, m, apple);
            }
        } else {
            for (Integer i : twoNodes) {
                ans += helper(i, m, apple);
            }
            if (ans > 0) {
                ans += 2;
            }
        }
        return ans;
    }
}
