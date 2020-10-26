package com.LianBiao;

import com.node.LinkNode;

//链表中中间的节点
//原理，利用快慢指针
public class DeleteHalfNode {
	public static void main(String[] args) {
		LinkNode first = construct();
		removeHalfNode(first);
		printList(first);
	}
	
	public static LinkNode removeHalfNode(LinkNode node) {
		if(node==null || node.next==null) {
			return node;
		}
		if (node.next.next==null) {
			return node.next;
		}
		LinkNode fast = node.next.next;
		LinkNode slow = node; //slow指的是要删除节点的前一个节点
		while(fast!=null&&fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		slow.next= slow.next.next;
		return node;
	}

	public static LinkNode construct() {
		LinkNode first = new LinkNode(2);
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
			System.out.println(node.value);
			node = node.next;
		}
	}
}
