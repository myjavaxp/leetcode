package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution0501 {
    private Integer cur;
    private int maxCount = 0;
    private int currentCount = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Set<Integer> res = new HashSet<>();
        loop(root, res);
        int i = 0;
        int[] array = new int[res.size()];
        for (Integer e : res) {
            array[i] = e;
            i++;
        }
        return array;
    }

    private void loop(TreeNode node, Set<Integer> res) {
        if (node == null) {
            return;
        }
        loop(node.left, res);
        //System.out.println(node.val);
        if (cur == null) {
            cur = node.val;
            maxCount++;
            currentCount++;
            res.add(cur);
        } else {
            if (node.val == cur) {
                currentCount++;
                if (currentCount == maxCount) {
                    res.add(cur);
                } else if (currentCount > maxCount) {
                    res.clear();
                    maxCount++;
                    res.add(cur);
                }
            } else {
                currentCount = 1;
                cur = node.val;
                if (currentCount == maxCount) {
                    res.add(cur);
                }
            }
        }
        loop(node.right, res);
    }
}
