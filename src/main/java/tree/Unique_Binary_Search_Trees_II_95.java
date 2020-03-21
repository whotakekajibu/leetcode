package tree;

import Utils.TreeNode;
import Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II_95 {

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
        for (TreeNode re : res) {
//            Utils.printTree(re);
        }
        System.out.println(res.size());
    }

    public static List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }

    public static List<TreeNode> helper(int min,int max){
        List<TreeNode> res = new ArrayList<>();
        if (min > max){
            return res;
        }
        if (min == max){
            res.add(new TreeNode(max));
            return res;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> left = helper(min,i-1);
            List<TreeNode> right = helper(i+1,max);
            for (TreeNode treeNode : left) {
                TreeNode cur = new TreeNode(i);
                cur.left = treeNode;
                res.add(cur);
            }
            for (TreeNode treeNode : right) {
                TreeNode cur = new TreeNode(i);
                cur.right = treeNode;
                res.add(cur);
            }
        }
        return res;
    }


}
