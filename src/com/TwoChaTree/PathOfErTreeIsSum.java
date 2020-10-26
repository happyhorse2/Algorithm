package com.TwoChaTree;

import java.util.ArrayList;

import com.node.TreeNode;

public class PathOfErTreeIsSum {
     public static void main(String[] args) {
    	 testFive();
	 }
     public static boolean HasSum(TreeNode root, int sum) {
    	 if (root==null) {
    		 return false;
    	 }
    	 return PathOfErTreeIsSumI(root, sum);
     }
     //判断根结点到二叉树叶子节点是否存在路径，相加和为target
     public static boolean PathOfErTreeIsSumI(TreeNode root, int target) {
          if(root==null) {
        	  return false;
          }
          if(root.value==target&&root.leftNode==null&&root.rightNode==null) {
        	  return true;
          }
          return PathOfErTreeIsSumI(root.leftNode, target-root.value)||PathOfErTreeIsSumI(root.rightNode, target-root.value);
     }
     //判断任意节点到叶子节点是否存在路径
     public static boolean PathOfErTreeIsSumII(TreeNode root, int target) {
         if(root==null) {
       	     return false;
         }
         if(root.value==target&&root.leftNode==null&&root.rightNode==null) {
       	       return true;
         }
         return PathOfErTreeIsSumI(root.leftNode, target-root.value)||PathOfErTreeIsSumI(root.rightNode, target-root.value)||PathOfErTreeIsSumII(root.leftNode, target)||PathOfErTreeIsSumII(root.rightNode, target);
    }
     
    //判断任意节点到任意节点是否相加和为sum
    public static boolean PathOfErTreeIsSumIII(TreeNode root, int target) {
    	 if(root==null) {
       	     return false;
         }
    	 if(root.value==target) {
    		 return true;
    	 }
    	 return PathOfErTreeIsSumI(root.leftNode, target-root.value)||PathOfErTreeIsSumI(root.rightNode, root.value-target)||PathOfErTreeIsSumI(root.leftNode, target)||PathOfErTreeIsSumIII(root.rightNode, target);
    }
    
    //求二叉树各个节点的路径和
    public static void sumPath(TreeNode node, int initial, ArrayList<Integer> array){
    	if(node==null) {
    		return ;
    	}
    	if(node.leftNode == null && node.rightNode == null) {
    		array.add(initial+node.value);
    	}
    	sumPath(node.leftNode, (initial+node.value)*10, array);
    	sumPath(node.rightNode, (initial+node.value)*10, array);
    }
    
    //求二叉树各个节点路径和不乘10
    public static void sumPathTwo(TreeNode node, int initial, ArrayList<Integer> array) {
    	if(node==null){
    		return ;
    	}
    	if(node.leftNode==null&&node.rightNode==null) {
    		 System.out.println("dddddd");
    	     array.add(initial+node.value);	
    	}
    	//System.out.println("kkk");
    	sumPathTwo(node.leftNode, initial+node.value, array);
    	sumPathTwo(node.rightNode, initial+node.value, array);
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
	
	
	public static void testFive() {
		TreeNode node = makeTeeNode();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		sumPathTwo(node, 0, arrayList);
		for(Integer i: arrayList) {
			System.out.println(i+"aaaaaaaa");
		}
	}
     
}
