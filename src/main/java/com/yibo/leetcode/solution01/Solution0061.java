package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

public class Solution0061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        int size = 0;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        size++;
        k = k % size;
        if (k == 0) {
            return head;
        }
        ListNode tail = head;//最后一个元素，即从1开始第（size-k）个元素
        ListNode res;
        for (int i = 0; i < size - k - 1; i++) {
            tail = tail.next;
        }
        res = tail.next;
        tail.next = null;
        node.next = head;
        return res;
    }
}
