package leetcode_cn.contest;

import Utils.ListNode;
import Utils.TreeNode;

import java.util.*;

/**
 * @Description
 * @Date 2020/5/16 22:29
 **/
public class Contest_20200516 {

    public static int maxPower(String s) {
        int l = 0, r = 1, ans = 0;
        while (r < s.length()) {
            char c = s.charAt(r++);
            if (c == s.charAt(l)) {
                ans = Math.max(ans, r - l);
            } else {
                char curLeft = s.charAt(l);
                while (s.charAt(l) == curLeft) {
                    l++;
                }
            }
        }
        return ans;
    }


    public static List<String> simplifiedFractions(int n) {
        Set<String> ans = new HashSet<>();
        int up, down;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int gcd = gcd(j, i);
                if (gcd != 1) {
                    up = i / gcd;
                    down = j / gcd;
                } else {
                    up = i;
                    down = j;
                }
                ans.add(up + "/" + down);
            }
        }
        return new ArrayList<>(ans);
    }


    public static int gcd(int a, int b) {
        int n;
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.val >= x) {
            ans++;
            x = root.val;
        }
        return ans + dfs(root.left, x) + dfs(root.right, x);
    }

    public static void main(String[] args) {
        //             1, 2, 3, 4, 5, 6, 7, 8, 9
        int[] costs = {5, 4, 4, 5, 5, 5, 5, 5, 5};
//        int[] costs = {7, 6, 5, 5, 5, 6, 8, 7, 8};
        int target = 29;
//        int target = 9;
        System.out.println(largestNumber(costs, target));
    }

    public static String largestNumber(int[] cost, int target) {
        sets = new HashSet<>();
        ans.clear();
        dfs(cost, 0, new ArrayList<>(), target);
        StringBuilder sb = new StringBuilder();
        if (ans.isEmpty()) {
            sb.append("0");
            return sb.toString();
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i));
        }
        return sb.toString();
    }

    public static List<Integer> max(List<Integer> l1, List<Integer> l2) {
        int len = l1.size();
        int len1 = l2.size();
        if (len > len1) {
            return l1;
        }
        if (len < len1) {
            return l2;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (l1.get(i) > l2.get(i)) {
                return l1;
            }
            if (l1.get(i) < l2.get(i)) {
                return l2;
            }
        }
        return l1;
    }


    static List<Integer> ans = new ArrayList<>();
    //    static int[][] memo;
    static Set<String> sets;

    public static void dfs(int[] cost, int idx, List<Integer> cur, int target) {
        String key = idx + "_" + cur + target;
        if (sets.contains(key)) {
            return;
        }
        if (target == 0) {
            ans = new ArrayList<>(max(ans, cur));
            return;
        }
        if (idx >= cost.length) {
            return;
        }
        for (int cnt = 0; cnt * cost[idx] <= target; cnt++) {
            for (int i = 0; i < cnt; i++) {
                cur.add(idx + 1);
            }
            dfs(cost, idx + 1, cur, target - cnt * cost[idx]);
            for (int i = 0; i < cnt; i++) {
                cur.remove(cur.size() - 1);
            }
        }
        sets.add(key);
    }


}
