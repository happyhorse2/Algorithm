package com.TwoChaTree;
//通过中序遍历和前序遍历，构造二叉树

import com.node.TreeNode;

public class MakeErChaTreeByPreOrderInOrder {
    public static void main(String[] args) {
    	int[] preOrder = {1,2,4,7,3,5,6,8};
    	int[] inOrder = {4,1,2,7,5,3,8,6};
//    	int[] preOrder = {1,2,3,4};
//    	int[] inOrder = {2,1,3,4};
    	TreeNode node = initial(preOrder, inOrder);
	}
    
    public static TreeNode initial(int[] preOrder, int inOrder[]) {
    	if (preOrder==null||preOrder.length==0) {
    		return null;
    	}
    	TreeNode node = construct(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
        return node;
    }
    
    public static TreeNode construct(int[] preOrder, int prestart, int preend, int[] inOrder, int instart, int inend){
    	if(prestart>preend) {
    		return null;
    	}
    	TreeNode node = new TreeNode(preOrder[prestart]);
    	//这里没考虑到
    	int rootInorder = instart;
    	
    	while(rootInorder<=inend&&node.value!=inOrder[rootInorder]) {
    		rootInorder++;
    	}
    	int leftLength = rootInorder-instart;
    	if(leftLength>0) {
    		node.leftNode = construct(preOrder, prestart+1, prestart+leftLength, inOrder, instart, instart+leftLength-1);
    	}
    	if(leftLength<preend-prestart) {
    		node.rightNode = construct(preOrder, prestart+leftLength+1, preend, inOrder, instart+leftLength+1, inend);
    	}
    	return node;
    }
}
