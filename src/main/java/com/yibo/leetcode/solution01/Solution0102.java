package com.yibo.leetcode.solution01;

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
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();
            if (level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            if (node.left != null) {
                queue.add(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, level + 1));
            }
        }
        return res;
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        private V getValue() {
            return value;
        }

        private K getKey() {
            return key;
        }

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}