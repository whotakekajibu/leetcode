package Tree;

import Utils.TreeNode;
import Utils.Utils;

public class DiameterofBinaryTree543 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		// node1.right = node3;
		// node2.left = node4;
		// node2.right = node5;
		diameterOfBinaryTree(node1);

	}

	private static int ans;

	public static int diameterOfBinaryTree(TreeNode root) {
		ans = 0;
		helper(root);
		System.out.println(ans);
		return ans;
	}

	// root节点的最长路径
	static int helper(TreeNode root) {
		if (root == null)
			return -1;
		int l = helper(root.left) + 1;
		int r = helper(root.right) + 1;
		ans = Math.max(ans, l + r);
		return Math.max(l, r);
	}

	static class Data {
		public int min;
		public int max;

		public Data(int min, int max) {
			this.min = min;
			this.max = max;
		}

	}
}
