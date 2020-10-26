package com.TwoChaTree;

import java.util.Stack;

import com.node.TreeNode;

public class PreOrderTraversal {
	public static void main(String[] args) {
		TreeNode node = makeTeeNode();
		PreOrderTravesalMethod(node);
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
	
	public static void PreOrderTravesalMethod(TreeNode root){
		TreeNode temp = root;
		Stack<TreeNode> stack =  new Stack<TreeNode>();
		TreeNode popRealNode = null;
		while(temp!=null||!stack.isEmpty()) {
			if (temp!=null) {
				System.out.print(temp.value);
				stack.add(temp);
				temp = temp.leftNode;
			}else {
				popRealNode = stack.pop();
				if (popRealNode.rightNode!=null) {
					temp = popRealNode.rightNode;
				}
			}
		}
	}
}
