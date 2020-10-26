package com.TwoChaTree;

import java.util.Stack;

import com.node.TreeNode;


public class InOrderTraversal {
	public static void main(String[] args) {
		TreeNode node = makeTeeNode();
		InOrderTraversalMethod(node);
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
	
	public static void InOrderTraversalMethod(TreeNode root) {
		TreeNode temp = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode poprealNode=null;
		while(temp!=null||!stack.isEmpty()) {
			if (temp!=null) {
				stack.add(temp);
				temp=temp.leftNode;
			}else {
				poprealNode = stack.pop();
				System.out.print(poprealNode.value);
				if(poprealNode.rightNode!=null) {
					temp=poprealNode.rightNode;
				}
			}
		}
	}
}
