package com.yibo.leetcode.day20180920;

import com.yibo.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution0257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return Collections.singletonList(String.valueOf(root.val));
        }
        if (root.left != null) {
            List<String> left = binaryTreePaths(root.left);
            for (String string : left) {
                res.add(String.valueOf(root.val) + "->" + string);
            }
        }
        if (root.right != null) {
            List<String> right = binaryTreePaths(root.right);
            for (String string : right) {
                res.add(String.valueOf(root.val) + "->" + string);
            }
        }
        return res;
    }
}
