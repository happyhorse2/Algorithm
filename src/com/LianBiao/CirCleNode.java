package com.LianBiao;

import com.node.ListNode;

public class CirCleNode {
    public static void main(String[] args) {

    }

    public static ListNode CirCleCha(ListNode head){
        if(head==null||head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (slow!=null&&fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if(slow==fast){
                break;
            }
        }
        if(slow==null||fast==null){
            return null;
        }
        while (head!=slow){
            head=head.next;
            slow=slow.next;
        }
        return head;
    }
}
