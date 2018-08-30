package com.yibo.leetcode.day20180814;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr.length < 1) {
            throw new IllegalArgumentException("Cannot put empty array!");
        }
        val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append(": front ");
        ListNode node = this;
        while (node.next != null) {
            stringBuilder.append(node.val).append(" -> ");
            node = node.next;
        }
        stringBuilder.append(node.val).append(" -> NULL");
        return stringBuilder.toString();
    }
}
