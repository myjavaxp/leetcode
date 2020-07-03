package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.TreeNode;

public class Solution0108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBst(0, nums.length - 1, nums);
    }

    private TreeNode toBst(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int mid = (l + r) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = toBst(l, mid - 1, nums);
        res.right = toBst(mid + 1, r, nums);
        return res;
    }
}
