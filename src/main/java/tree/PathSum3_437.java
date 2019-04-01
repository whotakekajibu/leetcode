package tree;

import Utils.TreeNode;

public class PathSum3_437 {
    public int pathSum(TreeNode root, int sum) {
        return 0;
    }

    int helper(TreeNode root, int cur, int sum) {
        if (root == null) return 0;
        if (cur == sum) return 1;
        int left = helper(root.left, cur, sum);
        int leftAndcur = helper(root.left, cur + root.val, sum);
        int right = helper(root.right, cur, sum);
        int rightAndcur = helper(root, cur + root.val, sum);
        return left + leftAndcur + right + rightAndcur;
    }
}
