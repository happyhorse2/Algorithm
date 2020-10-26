package com.LianBiao;

import com.node.LinkNode;
import com.node.ListNode;

import java.util.List;

//zhuanlianbiao, Kgeyizu
public class ReverseKGroup {
    public static void main(String[] args){
        ListNode pre = new ListNode(-1);
        ListNode head=construct();
        pre.next = head;
        ListNode result = reverLiannbiao(2, head, pre);
        printValue(result);
    }
    public static ListNode reverLiannbiao(int k, ListNode head, ListNode pre){
        int length = 1;
        ListNode temp=null;
        if(comLength(head)<k){
            return head;
        }
        ListNode node = head.next, next_pre = head;
        while (length<k&&node!=null){
            length++;
            temp = node;
            node = node.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        reverLiannbiao(k, node, next_pre);
        return pre.next;
    }

    public static int comLength(ListNode node){
        ListNode temp = node;
        int k = 0;
        while (temp!=null) {
            k++;
            temp = temp.next;
        }
        return k;
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
    public static void printValue(ListNode node){
        while (node!=null){
            System.out.print(node.val);
            node = node.next;
        }
    }
}
