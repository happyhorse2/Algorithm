package com.TwoChaTree;

import java.util.LinkedList;

import com.node.TreeNode;

//二叉树之字遍历
public class LevelBianliTwoChaTree {
	public static void main(String[] args) {
		TreeNode node = makeTeeNode();
		helpbianli(node);
//		LinkedList<Integer> linkedList = new LinkedList<Integer>();
//		linkedList.offer(1);
//		linkedList.offer(2);
//		System.out.print(linkedList.poll());
//		System.out.print(linkedList.size());
//		linkedList.offer(3);
//		System.out.print(linkedList.size());
//		System.out.print(linkedList.poll());
//		
		
	}
	
	public static void helpbianli(TreeNode node) {
		Boolean lefttoright = true;
		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
		linkedList.add(node);
		while(!linkedList.isEmpty()) {
			int size = linkedList.size();
			for(int i=0;i<size;i++) {
				TreeNode node3 = linkedList.poll();
				if(lefttoright) {
					System.out.println(node3.value);
					if(node3.leftNode!=null) {
						linkedList.offerFirst(node3.leftNode);
					}
					if(node3.rightNode!=null) {
						linkedList.offerFirst(node3.rightNode);
					}
				}else {
					System.out.println(node3.value);
					if(node3.rightNode!=null) {
						linkedList.offer(node3.rightNode);
					}
					if(node3.leftNode!=null) {
						linkedList.offer(node3.leftNode);
					}
				}
			}
			lefttoright = !lefttoright;
		}
		
	}

	public static TreeNode makeTeeNode() {
		TreeNode node = new TreeNode(1);
		TreeNode leftTreeNode = new TreeNode(2);
		TreeNode rightTreeNode = new TreeNode(3);
		TreeNode leftrightTreeNode = new TreeNode(5);
		node.leftNode = leftTreeNode;
		node.rightNode = rightTreeNode;
		leftTreeNode.rightNode = leftrightTreeNode;
		return node;
	}
}
