package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

public class Solution0203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.val == val) {
                cur.next = next.next;
                next.next = null;//使移除的元素可以被垃圾回收掉
            } else {
                cur = next;
            }
        }
        return dummyHead.next;
    }
}
