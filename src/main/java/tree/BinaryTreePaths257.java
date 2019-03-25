package tree;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;
import Utils.Utils;

public class BinaryTreePaths257 {
    public static void main(String[] args) {
        String[] str = {"1","2","#","5","#","#","3","#","#"};
        TreeNode root = Utils.createTreeBypre(str);
        Utils.preOrder(root);
        List<String> res = binaryTreePaths(root);
        res.stream().forEach(System.out::println);
        System.out.println("1".equals(1+""));
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        String[] s = new String[1];
        helper(root,list,s);
        return list;
    }
    public static void helper(TreeNode root, List<String> ls, String[] s){
        if(root == null) return;
        if(s[0] != null){
            s[0] += "->"+root.val;
        }else{
            s[0] = ""+root.val;
        }
        if(root.left == null && root.right == null){
            ls.add(s[0]);
            return;
        }
        helper(root.left,ls,s);
//        s[0] = tmp;
        helper(root.right,ls,s);
    }
}
