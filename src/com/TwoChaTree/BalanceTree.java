package com.TwoChaTree;

import com.node.TreeNode;

public class BalanceTree {
	 public static boolean result = true;
	    public static boolean IsBalanced_Solution(TreeNode root) {
	        Height(root, result);
	        return result;
	    }
	    public static int Height(TreeNode root, Boolean result){
	        if(root==null){
	            return 0;
	        }
	        ///为false时，树的高度已经不再重要了
	        int left = Height(root.leftNode, result);
	        if(result==false){
	            return left;
	        }
	        int right = Height(root.rightNode, result);
	        if(result==false){
	            return right;
	        }
	        System.out.println(left+","+right+","+root.value+","+root.leftNode+","+root.rightNode);
	        if(Math.abs(left-right)>1){
	        	System.out.print("kkkkk");
	            result = false;
	        }
	        return Math.max(left, right)+1;
	    }
	public static void main(String[] args) {
		TreeNode node = makeTeeNode();
		System.out.print(IsBalanced_Solution(node));
		
	}
	public static TreeNode makeTeeNode() {
		TreeNode node = new TreeNode(1);
		TreeNode leftTreeNode = new TreeNode(2);
		TreeNode rightTreeNode = new TreeNode(3);
		TreeNode leftleftTreeNode = new TreeNode(4);
		TreeNode leftrightTreeNode = new TreeNode(5);
		TreeNode leftleftleftTreeNode = new TreeNode(6);
		leftleftTreeNode.leftNode = leftleftleftTreeNode;
		leftTreeNode.leftNode =leftleftTreeNode;
		leftTreeNode.rightNode = leftrightTreeNode;
		node.leftNode = leftTreeNode;
		node.rightNode = rightTreeNode;
		return node;
	}
}