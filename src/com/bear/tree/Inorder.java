package com.bear.tree;

import com.bear.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Inorder {
	public List<Integer> inOrder1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		dfs(root, list);
		return list;
	}
	public void dfs(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		dfs(root.left, list);
		list.add(root.val);
		dfs(root.right, list);
	}

	public List<Integer> inOrder2(TreeNode root) {
		return null;
	}
}
