package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> numbers = getNumbers(root);
        int sum = 0;
        for (String string : numbers) {
            sum += Integer.valueOf(string);
        }
        return sum;
    }

    private List<String> getNumbers(TreeNode node) {
        List<String> res = new ArrayList<>();
        if (node.right == null && node.left == null) {
            res.add(String.valueOf(node.val));
            return res;
        }
        if (node.left != null) {
            List<String> numbers = getNumbers(node.left);
            for (String string : numbers) {
                res.add(String.valueOf(node.val) + string);
            }
        }
        if (node.right != null) {
            List<String> numbers = getNumbers(node.right);
            for (String string : numbers) {
                res.add(String.valueOf(node.val) + string);
            }
        }
        return res;
    }
}