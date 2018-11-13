package com.yibo.leetcode.solution02;

import com.yibo.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 不是很理解队列这种写法
 *
 * @author Yibo
 */
public class Solution0111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int minDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nextLast = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur.left == null && cur.right == null)
                return minDepth;
            if (cur.left != null) {
                queue.add(cur.left);
                nextLast = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLast = cur.right;
            }
            if (cur == last) {
                ++minDepth;
                last = nextLast;
            }
        }
        return minDepth;
    }
}
