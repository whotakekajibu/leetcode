package niuke;

import Utils.TreeNode;

import java.util.*;

/**
 * @Description
 * @Date 2020/8/5 15:26
 **/
public class shoppe {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();

    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //加当前借点
        int cur = root.val;
        if (root.left != null) {
            cur += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            cur += rob(root.right.left) + rob(root.right.right);
        }

        //不加当前节点

        int notAddCur = rob(root.left) + rob(root.right);
        return Math.max(cur, notAddCur);
    }
}
