package com.TwoChaTree;
import com.node.TreeNode;

//二叉树最长路径长度
public class MostLength {
	static int max = 0;
	public static void main(String[] args) {
		TreeNode node =  makeTeeNode();
		System.out.print(mostLengthOfBinaryTree(node));
	}
	public static int dfs(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int leftH = dfs(root.leftNode);
		int rightH = dfs(root.rightNode);
		max = Math.max(max, leftH+rightH);
		return Math.max(leftH, rightH)+1;
	}
	public static int mostLengthOfBinaryTree(TreeNode root) {
		if(root==null) {
			return 0;
		}
		dfs(root);
		return max;
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
