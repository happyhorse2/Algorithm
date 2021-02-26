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
		LinkNode cur = first.next;
		while(cur!=null) {
			pre = findPreInsert(head, cur);
			if(pre!=last) {
				last.next = cur.next;
				cur.next  = pre.next;
				pre.next = cur;
				cur = last.next;
			}else {
				last =  last.next;
				cur=cur.next;
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
