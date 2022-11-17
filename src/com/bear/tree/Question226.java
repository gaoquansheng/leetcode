package com.bear.tree;

import com.bear.base.TreeNode;

public class Question226 {

	// 翻转二叉树
	public TreeNode invertTree(TreeNode root) {
		dfs(root);
		return root;
	}

	public TreeNode dfs(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = dfs(root.left);
		TreeNode right = dfs(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
}
