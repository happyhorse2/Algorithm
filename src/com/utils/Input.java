package com.utils;
import java.util.Scanner;

class LinkNode {
	public int value;
	public LinkNode next;
	public LinkNode(int value){
		this.value = value;
	}
}

public class Input{
	public static void main(String[] args) {
		construct();
		//node = reverseFromMToNMethod(node, 1, 4);
		//printList(node);
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
	
	public static void construct() {
        Scanner scanner= new Scanner(System.in);
		int length = scanner.nextInt();
		int i=1;
		int age=0;
        LinkNode head = new LinkNode(-1);
		LinkNode node = null;
        LinkNode temp = head;
        while(i++<=length) {
			age = scanner.nextInt();
            node = new LinkNode(age);
            temp.next = node;
            temp=temp.next;
		}
        int from = scanner.nextInt();
        int to = scanner.nextInt();
		scanner.close();
        //System.out.print(head.next.value+","+from+","+to);
        head = reverseFromMToNMethod(head.next, from, to);
        printList(head);
	}
	
	public static void printList(LinkNode node) {
		while (node!=null) {
			System.out.print(node.value+" ");
			node = node.next;
		}
	}
}
