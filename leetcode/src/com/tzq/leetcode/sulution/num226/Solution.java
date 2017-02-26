package com.tzq.leetcode.sulution.num226;

public class Solution {
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		/*
		 * if (root.left==null) { root.left = root.right; root.right=null;
		 * return root; } if (root.right==null) { root.right = root.left;
		 * root.left = null; return root; }
		 */

		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		if (root.left != null) {
			invertTree(root.left);
		}
		if (root.right != null) {
			invertTree(root.right);
		}
		return root;

	}

	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(1);
		rootNode.left = new TreeNode(2);
		TreeNode node = invertTree(rootNode);

	}
}
