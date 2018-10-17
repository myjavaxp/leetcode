package com.yibo.leetcode.solution;

import com.yibo.leetcode.model.TreeNode;

public class Solution0437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    /**
     * 包含node的路径，和为sum
     *
     * @param node node
     * @param num  和
     * @return 个数
     */
    private int findPath(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == num) {
            res++;
        }
        res += findPath(node.left, num - node.val);
        res += findPath(node.right, num - node.val);
        return res;
    }
}
