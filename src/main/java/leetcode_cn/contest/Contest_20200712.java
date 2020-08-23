package leetcode_cn.contest;

import java.util.*;

/**
 * @Description
 * @Date 2020/7/12 11:32
 **/
public class Contest_20200712 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Set<Integer>> path = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] cur = edges[i];
            int from = cur[0];
            int to = cur[1];
            if (path.containsKey(from)){
                Set<Integer> integers = path.get(from);
                integers.add(to);
            }else {
                Set<Integer> integers = new HashSet<>();
                integers.add(to);
                path.put(from,integers);
            }
        }
        Deque<Integer> q = new LinkedList<>();
        q.offer(start);
        int ans = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();

            }
        }
        return ans;
    }
}
