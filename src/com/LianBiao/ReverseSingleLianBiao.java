package com.LianBiao;

import com.node.LinkNode;

//反转单向链表
public class ReverseSingleLianBiao {
	
	public static void main(String[] args) {
		LinkNode head = construct();
		//head = reverseMethod(head);
		head =  reverseMethodV2(head);
		printList(head);
	}
	
	public static LinkNode reverseMethod(LinkNode node) {
		LinkNode head = new LinkNode(-1);
		head.next= node;
		LinkNode temp = node.next;
		node.next = null;
		LinkNode temp2 = null;
		while(temp!=null) {
			temp2 = temp;
			temp= temp.next;
			temp2.next = head.next;
			head.next = temp2;
		}
		return head.next;
	}

	public static LinkNode reverseMethodV2(LinkNode node) {
		LinkNode pre, cur, nxt;
		pre=null; cur = node; nxt=node;
		while (cur!=null){
			nxt = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nxt;
		}
		return pre;
	}

	
	
	public static LinkNode construct() {
		LinkNode first = new LinkNode(7);
		LinkNode second = new LinkNode(3);
		LinkNode third = new LinkNode(4);
		LinkNode four = new LinkNode(5);
		LinkNode five = new LinkNode(6);
		LinkNode six = new LinkNode(7);
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
