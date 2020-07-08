package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

public class Solution1457 {
    public int pseudoPalindromicPaths(TreeNode root) {
        return helper(root, new int[10]);
    }

    private int helper(TreeNode node, int[] record) {
        if (node == null) {
            return 0;
        }
        int value = node.val;
        if (record[value] == 0) {
            record[value]++;
        } else {
            record[value] = 1;
        }
        if (node.left == null && node.right == null) {
            int sum = 0;
            for (int rec : record) {
                if (rec > 0) {
                    if (++sum > 1) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        int[] rightRecord = new int[record.length];
        System.arraycopy(record, 0, rightRecord, 0, record.length);
        return helper(node.left, record) + helper(node.right, rightRecord);
    }
}
