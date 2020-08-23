package niuke;

import java.util.*;

/**
 * @Description
 * @Date 2020/8/1 21:13
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String[] flArr = firstLine.split(" ");
        int nodeCnt = Integer.valueOf(flArr[0]);
        int listCnt = Integer.valueOf(flArr[1]);
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> srcs = new HashMap<>();
        while (listCnt > 0) {
            listCnt--;
            String s = sc.nextLine();
            String[] curThreeNum = s.split(" ");
            String key = curThreeNum[0] + "_" + curThreeNum[1];
            int third = Integer.valueOf(curThreeNum[2]);
            map.put(key, third);
            Integer src = Integer.valueOf(curThreeNum[0]);
            Integer dest = Integer.valueOf(curThreeNum[1]);
            if (srcs.containsKey(src)) {
                srcs.get(src).add(dest);
            } else {
                List<Integer> dests = new ArrayList<>();
                dests.add(dest);
                srcs.put(src, dests);
            }
        }
        String lastLine = sc.nextLine();
        String[] lastArr = lastLine.split(" ");
        int src = Integer.valueOf(lastArr[0]);
        int dest = Integer.valueOf(lastArr[1]);
        int res = minDis(map, srcs, new HashSet<>(), src, dest);
        if (res >= 9000) {
            System.out.println("-1");
        } else {
            System.out.println(res);
        }
    }

    public static int minDis(Map<String, Integer> map, Map<Integer, List<Integer>> srcs, Set<Integer> v, int src, int dest) {
        if (src == dest) {
            return 0;
        }
        if (!srcs.containsKey(src)) {
            return 9000;
        }
        List<Integer> dests = srcs.get(src);
        int ans = Integer.MAX_VALUE;
        for (Integer d : dests) {
            if (v.contains(d)) {
                continue;
            }
            v.add(d);
            String key = src + "_" + d;
            Integer curCost = map.get(key);
            if (curCost == null){
                continue;
            }
            int cost = minDis(map, srcs, v, d, dest);
            ans = Math.min(ans, cost + curCost);
        }
        return ans;
    }





}
