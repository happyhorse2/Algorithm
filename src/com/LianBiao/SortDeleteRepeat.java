package com.LianBiao;

import com.node.LinkNode;

public class SortDeleteRepeat {
    public static void main(String[] args) {
        LinkNode node = construct();
        deteteNodeV2(node);
        printList(node);
    }

    public static void deteteNode(LinkNode node){

        if(node==null||node.next==null){
            return ;
        }
        LinkNode temp = node;
        while (temp!=null&&temp.next!=null){
            if(temp.value==temp.next.value){
                temp.next = temp.next.next;
            }else{
             temp = temp.next;
            }
        }
    }

    public static LinkNode deteteNodeV2(LinkNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        LinkNode pre = null, pHead = node;
        LinkNode cur = node;
        while (cur != null) {
            if (cur.next != null && cur.value == cur.next.value) {
                while (cur.next != null && cur.value == cur.next.value) {
                    cur = cur.next;
                }
                cur = cur.next;
                if (pre == null) {
                    pHead = cur;
                } else {
                    pre.next = cur;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }



    public static LinkNode construct() {
        LinkNode first = new LinkNode(2);
        LinkNode second = new LinkNode(3);
        LinkNode third = new LinkNode(3);
        LinkNode four = new LinkNode(4);
        LinkNode five = new LinkNode(5);
        LinkNode six = new LinkNode(5);
        first.next = second;
        second.next = third;
        third.next=four;
        four.next = five;
        five.next = six;
        return first;
    }



    public static void printList(LinkNode node) {
        while (node!=null) {
            System.out.print(node.value);
            node = node.next;
        }
    }
}