package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int value = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode left = poll.left;
            if (poll.left != null) {
                queue.add(left);
                if (left.val != value) {
                    return false;
                }
            }
            TreeNode right = poll.right;
            if (poll.right != null) {
                queue.add(right);
                if (right.val != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
