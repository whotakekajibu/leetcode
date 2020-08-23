package leetcode_cn.may;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description
 * @Date 2020/5/13 14:25
 **/
public class Binary_tree_level_order_traversal_102_20200513 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode poll = q.poll();
                level.add(poll.val);
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, 1);
        return ans;
    }

    public void dfs(TreeNode root, List<List<Integer>> ans, int curLevel) {
        if (root == null) {
            return;
        }
        if (curLevel > ans.size()) {
            List<Integer> level = new ArrayList<>();
            level.add(root.val);
            ans.add(level);
        } else {
            List<Integer> level = ans.get(curLevel - 1);
            level.add(root.val);
        }
        dfs(root.left, ans, curLevel + 1);
        dfs(root.right, ans, curLevel + 1);
    }


}
