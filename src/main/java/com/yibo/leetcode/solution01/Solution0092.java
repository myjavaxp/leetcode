package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author yibo
 */
public class Solution0092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode start = null;
        ListNode end = null;
        ListNode begin = null;
        int flag = 1;
        while (flag <= n + 1) {
            if (flag == n + 1) {
                end = cur;
            } else {
                ListNode next = cur.next;
                if (flag < m) {
                    if (flag == m - 1) {
                        start = cur;
                    }
                } else {
                    if (flag == m) {
                        begin = cur;
                    }
                    cur.next = pre;
                }
                pre = cur;
                cur = next;
            }
            flag++;
        }
        if (start != null) {
            start.next = pre;
        } else {
            head = pre;
        }
        if (begin != null) {
            begin.next = end;
        }
        return head;
    }
}