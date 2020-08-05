package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

public class Solution0337 {
    public int rob(TreeNode root) {
        return Math.max(max(root, true), max(root, false));
    }

    private int max(TreeNode node, boolean contain) {
        if (node == null) {
            return 0;
        }
        if (contain) {
            return node.val + max(node.left, false) + max(node.right, false);
        } else {
            return Math.max(max(node.left, false), max(node.left, true)) + Math.max(max(node.right, false), max(node.right, true));
        }
    }
}
