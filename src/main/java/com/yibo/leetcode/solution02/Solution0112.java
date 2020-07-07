package com.yibo.leetcode.solution02;

import com.yibo.leetcode.model.TreeNode;

public class Solution0112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        boolean res = false;
        if (root.left != null) {
            res = hasPathSum(root.left, sum - root.val);
        }
        if (root.right != null) {
            res = res || hasPathSum(root.right, sum - root.val);
        }
        return res;
    }
}
