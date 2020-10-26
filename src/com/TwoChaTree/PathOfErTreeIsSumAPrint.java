package com.TwoChaTree;

import java.sql.Array;
import java.util.ArrayList;

import com.node.TreeNode;

//二叉树节点到叶子节点相加和为定值
public class PathOfErTreeIsSumAPrint {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
	}
	
	public static void PathOfErTreeIsSumAPrintMethod(TreeNode node, int k, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> arrays){
		if(node==null) {
			return ;
		}
		if(node.value==k&&node.leftNode==null||node.rightNode==null) {
			array.add(node.value);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i=0;i<array.size();i++) {
				temp.add(array.get(i));
			}
			arrays.add(temp);
			array.remove(node.value);
		}
		array.add(node.value);
		PathOfErTreeIsSumAPrintMethod(node.leftNode, k-node.value, array, arrays);
		PathOfErTreeIsSumAPrintMethod(node.rightNode, k-node.value, array, arrays);
		array.remove(array.size()-1); 
	}
	
}
