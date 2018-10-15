package com.yibo.leetcode.day20180920;

import com.yibo.leetcode.model.TreeNode;

public class Solution0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = left;
        }
        return root;
    }
}
