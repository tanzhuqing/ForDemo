package com.tzq.leetcode.sulution.num222;

public class Solution {
	// 二叉树特性的二分法，结合动态规划思想
	
    public int countNodes(TreeNode root) {
          int leftmost = leftmost(root);
          return CountLeft(root, leftmost);
    }
    
    private int CountLeft(TreeNode root,int leftmost){
        if (root==null) {
			return 0;
		}
        int count = 1;
        leftmost--;
        int middle = leftmost(root.right);
        if (leftmost == middle) {
			count += (1<<leftmost)-1;
			count += CountLeft(root.right, middle);
		}else {
			count += (1<<middle) -1;
			count += CountLeft(root.left, leftmost);
		}
        return count;
    }
    
    private int leftmost(TreeNode root){
    	int count = 0;
    	while (root!=null) {
			count++;
			root = root.left;
		}
    	return count;
    }
}
