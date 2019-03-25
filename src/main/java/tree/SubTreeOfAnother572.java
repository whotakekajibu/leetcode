package tree;

import Utils.TreeNode;

public class SubTreeOfAnother572 {
    public static void main(String[] args) {
//        String[] s = {"3", "4", "1", "0", "#", "#", "#", "2", "#", "#", "5", "#", "#"};
//        TreeNode st = Utils.createTreeBypre(s);
//        String[] t = {"4","1","#","#","2","#","#"};
//        TreeNode tt = Utils.createTreeBypre(t);
//        System.out.println(isSubtree(st,tt));
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.size();
        int i = 3,j =2;
        System.out.println(Integer.MAX_VALUE);
    }
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(sameTree(s,t)) return true;
        if(s != null &&((sameTree(s.left,t) || sameTree(s.right,t)))){
            return true;
        }
        if(t != null && (sameTree(s,t.left) || sameTree(s,t.right))){
            return true;
        }
        return false;
    }
    static boolean sameTree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s != null && t != null && s.val == t.val) return sameTree(s.left,t.left)&&sameTree(s.right,t.right);
        return false;
    }
}
