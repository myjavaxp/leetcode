package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(root, false));
        while (!stack.empty()) {
            Command command = stack.pop();
            if (command.s) {
                list.add(command.node.val);
            } else {
                if (command.node.right != null) {
                    stack.push(new Command(command.node.right, false));
                }
                if (command.node.left != null) {
                    stack.push(new Command(command.node.left, false));
                }
                stack.push(new Command(command.node, true));
            }
        }
        return list;
    }

    private static class Command {
        private TreeNode node;
        private boolean s;

        private Command(TreeNode node, boolean s) {
            this.node = node;
            this.s = s;
        }
    }
}
