package leetcode_cn.may;

import Utils.TreeNode;
import Utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2020/5/22 14:21
 **/
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {

    public static void main(String[] args) {
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 instance = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = instance.buildTree(preorder, inorder);
        Utils.printTree(treeNode);
    }

    /**
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map.clear();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, 0, preorder.length - 1);
    }


    public TreeNode helper(int[] preorder, int i, int j, int len) {
        if (i > len || j > len) {
            return null;
        }
        int curLen = map.get(preorder[i]) - j;
        TreeNode root = new TreeNode(preorder[i]);
        root.left = helper(preorder, i + 1, j, i + curLen);
        root.right = helper(preorder, i + curLen + 1, j + curLen + 1, len);
        return root;
    }
}
