package 树;

import java.util.Queue;

/**
 * @author MH
 * https://leetcode.cn/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {
	public TreeNode invertTree(TreeNode root) {
		preorderTraversal(root);
		return root;
    }
	
	public void preorderTraversal(TreeNode node) {
		if (node == null) return;
		TreeNode tempNode = node.left;
		node.left = node.right;
		node.right = tempNode;
		
		preorderTraversal(node.left);
		preorderTraversal(node.right);
		
	}
}
