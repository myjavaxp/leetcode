package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Solution0086 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode bigPre = null;
        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.val < x) {
                if (bigPre != null) {
                    ListNode big = bigPre.next;
                    bigPre.next = next;
                    cur.next = next.next;
                    next.next = big;
                    bigPre = next;
                } else {
                    cur = cur.next;
                }
            } else {
                if (bigPre == null) {
                    bigPre = cur;
                }
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
