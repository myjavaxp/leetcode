package com.yibo.leetcode.structrue.practice;

import com.yibo.leetcode.day20180814.ListNode;

public class RemoveElementsSolution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}