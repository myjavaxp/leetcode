package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class Solution0445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int value;
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                value = stack1.pop() + stack2.pop() + flag;
            } else if (!stack1.isEmpty()) {
                value = stack1.pop() + flag;
            } else {
                value = stack2.pop() + flag;
            }
            if (value > 9) {
                flag = 1;
                stack3.push(value % 10);
            } else {
                flag = 0;
                stack3.push(value);
            }
        }
        ListNode res = new ListNode(0);
        ListNode node = res;
        if (flag == 1) {
            res.val = 1;
            node = new ListNode(0);
            res.next = node;
        }
        while (stack3.size() != 1) {
            node.val = stack3.pop();
            node.next = new ListNode(0);
            node = node.next;
        }
        node.val = stack3.pop();
        return res;
    }
}
