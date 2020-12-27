package com.TwoChaTree;

import java.util.LinkedList;

import com.node.TreeNode;

//二叉树之字遍历
public class LevelBianliTwoChaTree {
	public static void main(String[] args) {
//		TreeNode node = makeTeeNode();
//		helpbianli(node);
//		LinkedList<Integer> linkedList = new LinkedList<Integer>();
//		linkedList.offer(1);
//		linkedList.offer(2);
//		System.out.print(linkedList.poll());
//		System.out.print(linkedList.size());
//		linkedList.offer(3);
//		System.out.print(linkedList.size());
//		System.out.print(linkedList.poll());
		int[] nums = {4,2,4,6};
		partition(nums, 0, nums.length-1);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
//		
		
	}
	public static int partition(int[] nums, int start, int end){
		int part = nums[start];
		while (start<end){
			while (start<end&&nums[end]>=part){
				end--;
			}
			nums[start]= nums[end];
			while (start<end&&nums[start]<=part){
				start++;
			}
			nums[end]= nums[start];

		}
		nums[start] = part;
		return start;

	}
	public static void swap(int[] nums, int a, int b){
		int temp;
		temp = nums[a];
		nums[a]= nums[b];
		nums[b]=temp;
	}

	
//	public static void helpbianli(TreeNode node) {
//		Boolean lefttoright = true;
//		LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
//		linkedList.add(node);
//		while(!linkedList.isEmpty()) {
//			int size = linkedList.size();
//			System.out.println("size: "+size);
//			for(int i=0;i<size;i++) {
//				TreeNode node3 = linkedList.poll();
//				if (lefttoright) {
//					System.out.println(node3.value);
//					if(node3.leftNode!=null) {
//						linkedList.offerFirst(node3.leftNode);
//						System.out.println("leftNode"+node3.leftNode.value);
//					}
//					if(node3.rightNode!=null) {
//						linkedList.offerFirst(node3.rightNode);
//						System.out.println("rightNode"+node3.rightNode.value);
//					}
//				}else {
//					System.out.println(node3.value);
//					if(node3.rightNode!=null) {
//						linkedList.offerFirst(node3.rightNode);
//					}
//					if(node3.leftNode!=null) {
//						linkedList.offerFirst(node3.leftNode);
//					}
//				}
//			}
//			lefttoright = !lefttoright;
//		}
//
//	}
//
//	public static TreeNode makeTeeNode() {
//		TreeNode node = new TreeNode(1);
//		TreeNode leftTreeNode = new TreeNode(2);
//		TreeNode rightTreeNode = new TreeNode(3);
//		TreeNode leftrightTreeNode = new TreeNode(5);
//		TreeNode leftleftTreeNode = new TreeNode(4);
//		TreeNode rightrightTreeNode = new TreeNode(7);
//		TreeNode rightleftTreeNode = new TreeNode(6);
//		node.leftNode = leftTreeNode;
//		node.rightNode = rightTreeNode;
//		leftTreeNode.rightNode = leftrightTreeNode;
//		leftTreeNode.leftNode = leftleftTreeNode;
//		rightTreeNode.leftNode = rightleftTreeNode;
//		rightTreeNode.rightNode = rightrightTreeNode;
//		return node;
//	}
}
