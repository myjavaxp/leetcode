package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution0543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        getHeight(root, map);

        return map.get(1);
    }

    private int getHeight(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left, map);
        int rightHeight = getHeight(node.right, map);
        map.put(1, Math.max(leftHeight + rightHeight, map.getOrDefault(1, 0)));
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
