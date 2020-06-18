package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

import java.util.Stack;

/**
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 */
public class Solution1028 {
    public TreeNode recoverFromPreorder(String S) {
        int start = 0;
        int n = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '-') {
                start = i;
                break;
            } else {
                n = c - '0' + n * 10;
            }
        }
        TreeNode root = new TreeNode(n);
        if (start == 0) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        n = 0;
        int h = 0;//上一个元素的高度
        int deep = 1;//当前元素高度
        boolean flag = true;//上一个元素是否是-
        for (int i = start + 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '-' && flag) {
                deep++;
                continue;
            }
            if (c == '-' || i == S.length() - 1) {
                flag = true;
                if (i == S.length() - 1) {
                    n = n * 10 + c - '0';
                }
                TreeNode node = new TreeNode(n);
                int e = deep - h;
                if (e == 1) {
                    TreeNode parent = stack.peek();
                    stack.push(node);
                    parent.left = node;
                } else {
                    stack.pop();
                    while (e < 0) {
                        stack.pop();
                        e++;
                    }
                    TreeNode parent = stack.peek();
                    parent.right = node;
                    stack.push(node);
                }
                h = deep;
                deep = 1;
                n = 0;
                continue;
            }
            flag = false;
            n = n * 10 + c - '0';

        }
        return root;
    }
}