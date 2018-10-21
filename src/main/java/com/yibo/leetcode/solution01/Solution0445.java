package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * @author Yibo
 */
public class Solution0445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        add(l1, l2, res);
        return res;
    }

    private int add(ListNode cur1, ListNode cur2, ListNode node) {
        if (cur1.next == null && cur2.next == null) {
            int value = cur1.val + cur2.val;
            node.val = value % 10;
            return value / 10;
        }
        node.next = new ListNode(0);
        ListNode next1 = cur1;
        ListNode next2 = cur2;
        if (cur1.next != null) {
            next1 = cur1.next;
        }
        if (cur2.next != null) {
            next2 = cur2.next;
        }
        int value = cur1.val + cur2.val + add(next1, next2, node.next);
        node.val = value & 10;
        return value / 10;
    }
}
