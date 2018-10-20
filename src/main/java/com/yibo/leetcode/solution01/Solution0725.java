package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

public class Solution0725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        ListNode node = root;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        if (k >= size) {
            for (int i = 0; i < k; i++) {
                if (root != null) {
                    ListNode next = root.next;
                    res[i] = root;
                    root.next = null;
                    root = next;
                }
            }
        } else {
            int a = size / k;//每组的个数
            int b = size % k;//前b个元素的长度为a+1
            ListNode cur = root;
            for (int i = 0; i < k; i++) {
                int count = a;
                if (i < b) {
                    count = a + 1;
                }
                res[i] = cur;
                for (int j = 0; j < count - 1; j++) {
                    cur = cur.next;
                }
                ListNode lastNode = cur;
                cur = cur.next;
                lastNode.next = null;
            }
        }
        return res;
    }
}
