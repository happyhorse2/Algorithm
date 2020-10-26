package com.LianBiao;

import java.util.ArrayList;
import java.util.Stack;

import com.node.ListNode;

public class PrintLianBiaoFromTailToHead {
	public static void main(String[] args) {
		
	}
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode == null) {
			return null;
		}
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		while(listNode!=null) {
			stack.add(listNode.val);
			listNode = listNode.next;
		}
		while(stack.isEmpty()) {
			arrayList.add(stack.pop());
		}
		return arrayList;
	}
}
