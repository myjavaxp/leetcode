package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

public class Solution0111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null && right != null) {
            return Math.min(minDepth(left), minDepth(right)) + 1;
        } else if (left != null) {
            return minDepth(left) + 1;
        } else if (right != null) {
            return minDepth(right) + 1;
        } else {
            return 1;
        }
    }
}