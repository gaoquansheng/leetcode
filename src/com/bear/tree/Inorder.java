package com.bear.tree;

import com.bear.base.TreeNode;

import java.util.ArrayDeque;
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
		ArrayList<Integer> integers = new ArrayList<>();
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
			}
			root = stack.pop();
			integers.add(root.val);
			root = root.right;
		}
		return integers;
	}
}
