package leetcode_cn.may;

import Utils.TreeNode;

/**
 * @Description
 * @Date 2020/5/7 19:35
 **/
public class Subtree_of_another_tree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            if (s.val == t.val) {
                return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
            } else {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        } else if (s == null && t == null) {
            return true;
        } else {
            return false;
        }
    }
}
