package com.yibo.leetcode.day20180920;

import com.yibo.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            if (level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            if (node.left != null) {
                queue.add(new Pair(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, level + 1));
            }
        }
        return res;
    }

    private class Pair {
        private TreeNode node;
        private int level;

        private Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
