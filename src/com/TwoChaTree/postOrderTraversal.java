package com.TwoChaTree;

import java.util.Stack;

import com.node.TreeNode;

public class postOrderTraversal {
	public static void main(String[] args) {
		TreeNode node = makeTeeNode();
		portOrderTraversalMethod(node);
	}
	
	public static void portOrderTraversalMethod(TreeNode root) {
		TreeNode temp = root;
		Stack<TreeNode> nodeStatck = new Stack<TreeNode>();
		TreeNode poptempNode=null, lastPopNode=null,poprealNode=null;
		while(nodeStatck.size()>0||temp!=null) {
			if (temp!=null) {
				nodeStatck.add(temp);
				temp=temp.leftNode;
			}else {
				poptempNode = nodeStatck.peek();
				if (poptempNode.rightNode!=null && poptempNode.rightNode!=lastPopNode) {
					temp = poptempNode.rightNode;
				}else {
					poprealNode = nodeStatck.pop();
					System.out.print(poprealNode.value);
					lastPopNode = poprealNode;
				}					
			}			
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
