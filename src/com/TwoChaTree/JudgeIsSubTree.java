package com.TwoChaTree;

import com.node.TreeNode;


//判断一个树，是不是另一个树的子结构
public class JudgeIsSubTree {
	public static void main(String[] args) {
		
	}
	public static boolean judgeIsSubTreeMethod(TreeNode a, TreeNode b) {
		if(a==null||b==null) {
			return false;
		}
		return isRoot(a, b)||judgeIsSubTreeMethod(a.leftNode, b)||judgeIsSubTreeMethod(a.rightNode, b);
	}
	public static boolean isRoot(TreeNode a, TreeNode b) {
		if(b==null) {
			return true;
		}
		if(a==null) {
			return false;
		}
		if(a.value!=b.value) {
			return false;
		}
		return isRoot(a.leftNode, b.leftNode)&&isRoot(a.rightNode, b.rightNode);
	}
}
