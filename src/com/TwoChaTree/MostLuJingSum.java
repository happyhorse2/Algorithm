package com.TwoChaTree;


import com.node.TreeNode;

//二叉树最大路径和
public class MostLuJingSum {
	static int maxValue=Integer.MIN_VALUE;
	public static void main(String[] args) {
		TreeNode node =  makeTeeNode();
		System.out.print(MathPathSum(node));
	}
	
	public static int MathPathSum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		getMaxPathSum(root);
		return maxValue;
	}
	
	public static int getMaxPathSum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftMax = getMaxPathSum(root.leftNode);
		int rightMax = getMaxPathSum(root.rightNode);
		maxValue =  Math.max(maxValue, root.value+leftMax+rightMax);
		return root.value+Math.max(leftMax, rightMax);
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
