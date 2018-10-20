package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Yibo
 */
public class Solution0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode pre = cur;
        int flag = 0;
        while (l1 != null || l2 != null) {
            pre = cur;
            int value;
            if (l1 != null && l2 != null) {
                value = l1.val + l2.val + flag;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                value = l1.val + flag;
                l1 = l1.next;
            } else {
                value = l2.val + flag;
                l2 = l2.next;
            }
            if (value > 9) {
                flag = 1;
                cur.val = (value % 10);
            } else {
                flag = 0;
                cur.val = value;
            }
            cur.next = new ListNode(0);
            cur = cur.next;
        }
        if (flag == 1) {
            cur.val = 1;
        } else {
            pre.next = null;
        }
        return res;
    }
}
