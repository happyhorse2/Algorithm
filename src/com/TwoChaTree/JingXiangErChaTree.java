package com.TwoChaTree;

import com.node.TreeNode;

//镜像二叉树
public class JingXiangErChaTree {
	public static void main(String[] args) {
		
	}
	
	public static void jingXiangErChaTree(TreeNode root) {
		if(root==null) {
			return ;
		}
		jingXiangErChaTree(root.leftNode);
		jingXiangErChaTree(root.rightNode);
		TreeNode temp = null;
		temp = root.leftNode;
		root.leftNode = root.rightNode;
		root.rightNode = temp;
	}
}	
