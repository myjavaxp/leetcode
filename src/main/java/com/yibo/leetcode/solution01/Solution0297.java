package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0297 {
    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder res = new StringBuilder("");
        int levelTotalCount = 1;
        int levelCount = 0;
        int emptyCount = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            append(res, node);
            levelCount++;

            queue.add(node == null ? null : node.left);
            queue.add(node == null ? null : node.right);
            if (node == null) {
                emptyCount++;
            } else if (node.left == null && node.right == null) {
                emptyCount++;
            }
            if (emptyCount == levelTotalCount) {
                break;
            }
            if (levelCount == levelTotalCount) {
                levelTotalCount = levelTotalCount * 2;
                levelCount = 0;
                emptyCount = 0;
            }
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] array = data.split(",");
        if (NULL.equals(array[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        if (array.length == 1) {
            return root;
        }
        setLeaf(root, array, 0);
        return root;
    }

    private void append(StringBuilder builder, TreeNode node) {
        if (node == null) {
            builder.append("null,");
        } else {
            builder.append(node.val).append(",");
        }
    }

    private void setLeaf(TreeNode node, String[] array, int index) {
        if (node == null) {
            return;
        }
        int right = (index + 1) * 2;
        int left = right - 1;
        if (right > array.length - 1) {
            return;
        }
        if (!NULL.equals(array[left])) {
            node.left = new TreeNode(Integer.parseInt(array[left]));
            setLeaf(node.left, array, left);
        }
        if (!NULL.equals(array[right])) {
            node.right = new TreeNode(Integer.parseInt(array[right]));
            setLeaf(node.right, array, right);
        }
    }
}
