package com.yibo.leetcode.solution02;

import com.yibo.leetcode.model.TreeNode;

/**
 * 推荐解法
 */
public class Solution0222 {
    private int leftmost(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int countLeft(TreeNode root, int leftmost) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        leftmost--;
        int middle = leftmost(root.right);
        if (leftmost == middle) {
            count += (1 << leftmost) - 1;
            count += countLeft(root.right, middle);
        } else {
            count += (1 << middle) - 1;
            count += countLeft(root.left, leftmost);
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        int leftmost = leftmost(root);
        return countLeft(root, leftmost);
    }
}
