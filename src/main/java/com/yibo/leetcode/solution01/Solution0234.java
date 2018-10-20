package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

import java.util.Stack;

public class Solution0234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(head.val)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
