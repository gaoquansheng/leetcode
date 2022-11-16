package com.bear.tree;

import com.bear.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PreOrder {

	public List<Integer> preOrder1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		dfs(root, list);
		return list;
	}
	public void dfs(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preOrder1(root.left);
		preOrder1(root.right);
	}

	// 前序遍历，使用栈
	public List<Integer> preOrder2(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		while(root != null || !stack.isEmpty()) {
			while (root != null) {
				res.add(root.val);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop().right;

		}
		return res;
	}
}
