package com.LianBiao;

import com.node.LinkNode;

public class SortLianBiao {
	public static void main(String[] args) {
		LinkNode node = construct();
		node = sortLianBiaoMethod(node);
		printList(node);
	}
	
	public static LinkNode sortLianBiaoMethod(LinkNode first) {
		if (first==null) {
			return first;
		}
		LinkNode head = new LinkNode(-1);
		head.next = first;
		LinkNode pre, temp2, last = first;
		LinkNode temp = first.next;
		while(temp!=null) {
			pre = findPreInsert(head, temp);
			if(pre!=last) {
				temp2 = temp;
				temp = temp.next;
				last.next = temp2.next;
				temp2.next= pre.next;
				pre.next = temp2;
			}else {
				last =  last.next;
				temp = temp.next;
			}
		}
		return head.next;
	}
	
	public static LinkNode findPreInsert(LinkNode head, LinkNode node) {
		LinkNode pre= head;
		LinkNode temp = head.next;
		int value = node.value;
		while(temp!=null&&temp!=node) {
			if(value<temp.value) {
				break;
			}else {
				temp=temp.next;
				pre = pre.next;
			}
		}
		return pre;
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
	
	public static void printList(LinkNode node) {
		while (node!=null) {
			System.out.print(node.value);
			node = node.next;
		}
	}
}
