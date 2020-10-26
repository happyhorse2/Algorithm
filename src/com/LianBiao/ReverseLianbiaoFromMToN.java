package com.LianBiao;

import com.node.LinkNode;

public class ReverseLianbiaoFromMToN {
	public static void main(String[] args) {
		LinkNode node = construct();
		node = reverseFromMToNMethod(node, 1, 4);
		printList(node);
	}
	
	public static LinkNode reverseFromMToNMethod(LinkNode first, int m, int n) {
		if (first == null) {
			return first;
		}
		LinkNode preM = null;
		LinkNode proN = null;
		int len = 0;
		LinkNode node = first;
		while(node!=null) {
			len++;
			preM = len==m-1?node:preM;
			proN = len==n+1?node:proN;
			node=node.next;
		}
		if(m<1||n>len||n<m) {
			return first;
		}
		LinkNode head = new LinkNode(-1);
		if(preM==null) {
			head.next = first;
		}
		else {
			head.next = preM.next;
		}
		LinkNode temp = head.next.next;
		head.next.next = proN;
		LinkNode temp2 =null;
		while(temp!=proN){
			temp2 = temp;
			temp = temp.next;
			temp2.next = head.next;
			head.next = temp2;
		}
		if(preM==null) {
			return head.next;
		}
		else {
			preM.next = head.next;
			return first;
		}
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
			System.out.print(node.value);
			node = node.next;
		}
	}
}
