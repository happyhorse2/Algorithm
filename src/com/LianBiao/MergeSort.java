package com.LianBiao;

import com.node.LinkNode;
import sun.awt.image.ImageWatched;

public class MergeSort {
    public static void main(String[] args) {
        LinkNode node = construct();
        LinkNode nodeTest= SortMethod(node);
        printList(nodeTest);
    }

    public static LinkNode SortMethod(LinkNode head){
        if(head==null||head.next==null){
            return head;
        }
        LinkNode mid = midLinkNode(head);
        if (mid==null){
            return head;
        }
        LinkNode right = mid.next;
        mid.next = null;
        System.out.println(mid.value);
        LinkNode leftHead = SortMethod(head);
        LinkNode rightHead = SortMethod(right);
        return mergeSortMethod(leftHead, rightHead);
    }

    public static LinkNode mergeSortMethod(LinkNode left, LinkNode right){
        if(left==null){
            return right;
        }
        if(right == null){
            return left;
        }
        LinkNode node = new LinkNode(-1);
        LinkNode head=node;
        while (left!=null&&right!=null){
            if(left.value<=right.value){
                node.next =  left;
                left=left.next;
            }else{
                node.next = right;
                right=right.next;
            }
            node = node.next;
        }
        if(left==null){
            node.next = right;
        }
        if(right == null){
            node.next = left;
        }
        return head.next;

    }

    public static LinkNode midLinkNode(LinkNode head){
        if(head==null||head.next==null){
            return head;
        }
        LinkNode slow = head;
        LinkNode quick = head;
        while (quick.next!=null&&quick.next.next!=null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }


    public static void printList(LinkNode node) {
        while (node!=null) {
            System.out.print(node.value);
            node = node.next;
        }
    }

    public static LinkNode construct() {
        LinkNode first = new LinkNode(7);
        LinkNode second = new LinkNode(3);
        LinkNode third = new LinkNode(4);
        LinkNode four = new LinkNode(9);
        LinkNode five = new LinkNode(6);
        LinkNode six = new LinkNode(7);
        first.next = second;
        second.next = third;
        third.next=four;
        four.next = five;
        five.next = six;
        return first;
    }
}