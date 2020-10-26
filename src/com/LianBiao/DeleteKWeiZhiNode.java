package com.LianBiao;
import com.node.LinkNode; 
//删除第K个位置的节点
public class DeleteKWeiZhiNode {
	public static void main(String[] args) {
		LinkNode first = construct();
		first = deleteKWeiZhiNodeMethod(first, 1);
		printList(first);
	}
	
	public static LinkNode deleteKWeiZhiNodeMethod(LinkNode first, int k) {
		LinkNode temp = first;
		LinkNode last = null;
		while(temp!=null) {
			k--;
			if(k==0) {
				break; 
			}
			last = temp;
			temp = temp.next;
		}
		if(k>0) {
			return first;
		}
		if(last == null) {
			first = first.next;
		}else {
			last.next = temp.next;
		} 
		return first;
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
