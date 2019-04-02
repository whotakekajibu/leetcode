package tree;

import java.util.ArrayList;
import java.util.List;

import Utils.TreeNode;
import Utils.Utils;

public class MaximumWidthofBinaryTree_662 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		root.left = n1;
		root.right = n2;
//		Utils.printTree(root);
//		System.out.println(widthOfBinaryTree(root));
		System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
	}

    public static String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int l = 0,r = ch.length - 1;
        while(l < r){
            if(isAlph(ch[l])){
                if(isAlph(ch[r])){
                    char t = ch[l];
                    ch[l] = ch[r];
                    ch[r] = t;
                    l++;
                }
                r--;
            }else{
                l++;
            }
        }
        return new String(ch);
     }
           
	private static boolean isAlph(char c) {
		return c >= 65 && c <= 90 || c >= 97 && c <= 122;
	}

	public static int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		return helper(root, 1, 0, new ArrayList<>());
	}

	private static int helper(TreeNode root, int coordinate, int level, List<Integer> list) {
		if (root == null)
			return 0;
		if (level >= list.size())
			list.add(coordinate);
		int res = coordinate - list.get(level) + 1;
		int leftchild = helper(root.left, 2 * coordinate, level + 1, list);
		int rightchild = helper(root.left, 2 * coordinate + 1, level + 1, list);
		return max3(res, leftchild, rightchild);
	}

	public static int max3(int a, int b, int c) {
		if (a < b)
			a = b;
		if (a < c)
			a = c;
		return a;
	}

}
