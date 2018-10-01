package com.yibo.leetcode.day20180920;

import com.yibo.leetcode.model.ListNode;

public class Solution0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next=cur.next;
            if(cur.val==next.val){
                cur.next=next.next;
            }else{
                cur=next;
            }
        }
        return head;
    }
}
