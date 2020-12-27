package com.LianBiao;

import com.node.LinkNode;
import com.node.ListNode;

public class ReverseLianbiaoFromMToN {
	public  static ListNode successNode = null;
	public static void main(String[] args) {
		ListNode node = construct();
		node = reverseLianBiaoV3(node, 1, 4);
		printList(node);
	}

	//单个链表的递归反转
	public ListNode reverseLianBiaoV1(ListNode head){
		if(head.next==null) return head;
		ListNode newHead = reverseLianBiaoV1(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

	//部分链表的反转
	public static ListNode reverseLianBiaoV2(ListNode head, int n){
		if(n==1){
			successNode = head.next;
			return head;
		}
		ListNode last = reverseLianBiaoV2(head.next, n-1);
		head.next.next = head;
		head.next = successNode;
		return last;
	}

	//部分表的反转从M到N,
	public static ListNode reverseLianBiaoV3(ListNode head,int m, int n){
		if(m==1){
			return reverseLianBiaoV2(head, n);
		}
		head.next = reverseLianBiaoV3(head.next, m-1, n-1);
		return head;
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
	
	public static void printList(ListNode node) {
		while (node!=null) {
			System.out.print(node.val);
			node = node.next;
		}
	}
}
