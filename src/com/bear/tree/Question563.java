package com.bear.tree;

import com.bear.base.TreeNode;

public class Question563 {
	int res = 0;
	public int findTilt(TreeNode root) {
		dfs(root);
		return res;
	}
	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		res += Math.abs(left-right);
		return left+right+root.val;
	}
}
