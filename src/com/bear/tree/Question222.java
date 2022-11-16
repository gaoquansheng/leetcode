package com.bear.tree;

import com.bear.base.TreeNode;

public class Question222 {

    public int countNodes(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return left+right+1;
    }

    public static void main(String[] args) {
        Question222 question222 = new Question222();
        question222.countNodes2(new TreeNode(2,null,null));
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = (1<<level)-1;
        int high = 1 << (level+1);
        while (low + 1 != high) {
            int mid = low + (high-low)/2;
            if (isBlue(root, level, mid)) {
                low = mid;
            }else {
                high = mid;
            }
        }
        return low;
    }
    public boolean isBlue(TreeNode root, int level, int k) {
        int bit = 1 << (level-1);
        TreeNode node = root;
        while (node != null && bit > 0) {
            if ((bit&k) == 0) {
                node = node.left;
            }else {
                node = node.right;
            }
            bit >>=1;
        }
        return node != null;
    }
}
