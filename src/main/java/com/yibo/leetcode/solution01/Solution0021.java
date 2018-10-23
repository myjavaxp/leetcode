package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

/**
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution0021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null || l2 != null) {
            cur.next = new ListNode(0);
            cur = cur.next;
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.val = l1.val;
                    l1 = l1.next;
                } else {
                    cur.val = l2.val;
                    l2 = l2.next;
                }

            } else if (l1 != null) {
                cur.val = l1.val;
                l1 = l1.next;
            } else {
                cur.val = l2.val;
                l2 = l2.next;
            }
        }
        ListNode res = dummyHead.next;
        dummyHead.next = null;
        return res;
    }
}
