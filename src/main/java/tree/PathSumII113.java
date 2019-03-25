package tree;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    public static void main(String[] args) {
//        String[] strs = {"5", "4", "11", "7", "#", "#", "2", "#", "#", "#", "8", "13", "#", "#", "4", "5", "#", "#", "1", "#", "#"};
//        TreeNode node = Utils.createTreeBypre(strs);
//        System.out.println(pathSum(node, 22));
        TreeNode node = new TreeNode(1);
        TreeNode tmp = node;
        System.out.println(tmp.val);
        node = new TreeNode(2);
        System.out.println(tmp.val);
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, 0, sum, path, res);
        return res;
    }

    static void helper(TreeNode root, int cur, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        cur += root.val;
        if (root.left == null && root.right == null) {
            if (cur == sum) {
                List<Integer> tmp = (List<Integer>) ((ArrayList<Integer>) path).clone();
                res.add(tmp);
            }
            return;
        }
        helper(root.left, cur, sum, path, res);
        if(root.left != null){
            path.remove(path.size() - 1);
        }
        helper(root.right, cur, sum, path, res);
        if(root.right != null){
            path.remove(path.size() - 1);
        }
    }
}
