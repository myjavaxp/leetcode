package com.yibo.leetcode.day20180920;

public class Solution0206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private class ListNode {
        private int val;
        private ListNode next;

        private ListNode(int x) {
            val = x;
        }
    }
}
