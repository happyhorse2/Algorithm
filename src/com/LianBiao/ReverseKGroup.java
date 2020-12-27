package com.LianBiao;

import com.node.LinkNode;
import com.node.ListNode;

import java.util.List;

//zhuanlianbiao, Kgeyizu
public class ReverseKGroup {
    public static void main(String[] args){

    }

    public static ListNode construct() {
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(7);
        first.next = second;
        second.next = third;
        third.next=four;
        four.next = five;
        five.next = six;
        return first;
    }


    //反转节点a和节点b之间的链表，含b
    public static ListNode reverseMethodV3(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre=null; cur = a; nxt=a;
        while (cur!=b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    //k为1相当于未反转
    public static ListNode reverseKGroup(ListNode node,int k){
        if(node==null||k<0) return node;
        ListNode a=node,b=node;
        for (int i=0; i<k;i++){
            if(b==null) return node;
            b=b.next;
        }
        ListNode newHead = reverseMethodV3(a,b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

}
