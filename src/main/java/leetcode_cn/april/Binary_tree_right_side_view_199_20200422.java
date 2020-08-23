package leetcode_cn.april;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2020/4/22 21:11
 **/
public class Binary_tree_right_side_view_199_20200422 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        if (root == null){
            return ans;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            while (len > 0) {
                len--;
                TreeNode poll = q.poll();
                if (len == 0){
                    ans.add(poll.val);
                }
                if (poll.left != null){
                    q.offer(poll.left);
                }
                if (poll.right != null){
                    q.offer(poll.right);
                }
            }
        }
        return ans;
    }
}
