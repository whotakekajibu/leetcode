package tree.Lowest_Common_Ancestor_of_a_Binary_Tree;

import Utils.TreeNode;

import java.util.HashMap;

/**
 * @Description
 * @Date 2020/5/11 11:07
 **/
public class Lowest_Common_Ancestor_of_a_Binary_Tree_236_20200511 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root == null){
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return root;
        }
    }
}
