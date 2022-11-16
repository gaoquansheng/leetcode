package com.bear.tree;

import com.bear.base.TreeNode;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostOrder {
    public List<Integer> postOrder1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left,list);
        dfs(root.right,list);
        list.add(root.val);
    }

    public List<Integer> postOrder2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop().left;
        }
        Collections.reverse(res);
        return res;
    }
}
