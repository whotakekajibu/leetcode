package tree;

import Utils.TreeNode;
import Utils.Utils;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeMaximumPathSum_124 {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node7L0 = new TreeNode(0);
        node7.left = node7L0;
        TreeNode node7L0Ln1 = new TreeNode(-1);
        TreeNode node7L0Rn6 = new TreeNode(-6);
        node7L0.left = node7L0Ln1;
        node7L0.right = node7L0Rn6;
        TreeNode node7L0Ln1R1 = new TreeNode(1);
        node7L0Ln1.right = node7L0Ln1R1;
        TreeNode node7L0Ln1R1Ln7 = new TreeNode(-7);
        node7L0Ln1R1.left = node7L0Ln1R1Ln7;

//        Utils.printTree(node7);
        System.out.println(maxPathSum(node7));
    }

    public static int maxPathSum(TreeNode root) {
        Data data = helper(root);
        return data.sum;
    }

    public static Data helper(TreeNode root) {
        if (root == null) return null;
        Data left = helper(root.left);
        Data right = helper(root.right);
        int childSum = root.val;
        int sum = 0;
        TreeNode node;
        if (left == null && right == null) {
            return new Data(root.val, root.val, root);
        } else if (left == null) {
            childSum += right.childSum;
            if (right.node == root.right && root.val >= 0) {
                sum = right.sum + root.val;
                node = root;
            } else {
                sum = right.sum;
                node = right.node;
            }
        } else if (right == null) {
            childSum += left.childSum;
            if (left.node == root.left && root.val >= 0) {
                sum = left.sum + root.val;
                node = root;
            } else {
                sum = left.sum;
                node = left.node;
            }
        } else {
            childSum += Math.max(left.childSum, right.childSum);
            if (left.sum >= right.sum) {
                if (root.val >= 0) {
                    if (left.node == root.left) {
                        sum = max(left.sum + root.val, left.childSum + right.childSum + root.val);
                    } else {
                        sum = max(left.sum, childSum, left.childSum + right.childSum + root.val);
                    }
                    if (sum == left.sum + root.val) {
                        node = root;
                    } else {
                        node = left.node;
                    }
                } else {
                    sum = max(left.sum, childSum, left.childSum + right.childSum + root.val);
                    if (sum == left.sum) {
                        node = left.node;
                    } else {
                        node = root;
                    }
                }
            } else {
                if (root.val >= 0) {
                    if (right.node == root.right) {
                        sum = max(right.sum + root.val, left.childSum + right.childSum + root.val);
                    } else {
                        sum = max(right.sum, childSum, left.childSum + right.childSum + root.val);
                    }
                    if (sum == root.val + right.sum) {
                        node = root;
                    } else {
                        node = right.node;
                    }
                } else {
                    sum = max(right.sum, childSum, left.childSum + right.childSum + root.val);
                    if (sum == right.sum) {
                        node = right.node;
                    } else {
                        node = root;
                    }
                }
            }
            //MathUtils.max(left.childSum,right.childSum)+root.val,left.childSum+right.childSum+root.val,MathUtils.max(left.sum,right.sum),sum
        }
        if (sum < root.val) {
            sum = root.val;
            node = root;
        }
        return new Data(sum, childSum, node);
    }

    static int max(int... nums) {
        int a = nums[0];
        for (int n : nums) {
            if (n > a) {
                a = n;
            }
        }
        return a;
    }

    static class Data {
        int sum;
        int childSum;
        TreeNode node;

        public Data(int rootSum, int childSum, TreeNode node) {
            this.sum = rootSum;
            this.childSum = childSum;
            this.node = node;
        }
    }
}