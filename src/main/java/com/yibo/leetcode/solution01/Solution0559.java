package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.Node;

import java.util.List;

public class Solution0559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        List<Node> list = root.children;
        if (list == null) {
            return 1;
        }
        int res = 1;
        for (Node node : list) {
            res = Math.max(res, maxDepth(node) + 1);
        }
        return res;
    }
}
