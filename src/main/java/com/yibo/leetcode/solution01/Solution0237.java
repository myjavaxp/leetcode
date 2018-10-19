package com.yibo.leetcode.solution01;

import com.yibo.leetcode.model.ListNode;

public class Solution0237 {
    public void deleteNode(ListNode node) {
        ListNode cur=node;
        while (true){
            ListNode next=cur.next;
            cur.val=next.val;
            if(next.next==null){
                cur.next=null;
                break;
            }
            cur=next;
        }
    }
}
