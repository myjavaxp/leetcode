package com.yibo.leetcode.solution02;

import com.yibo.leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 作弊代码，不推荐
 */
public class Solution0222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode cur = queue.poll();
            if (cur.val != -105) {
                cur.val = -105;
                if (cur.left != null) {
                    queue.offer(cur.left);
                    count++;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    count++;
                }
            }
        }
        return count;
    }
}
