package com.yibo.leetcode.solution;

import com.yibo.leetcode.model.TreeNode;

public class Solution0104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
