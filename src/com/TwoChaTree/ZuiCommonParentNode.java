package com.TwoChaTree;

import com.node.TreeNode;

public class ZuiCommonParentNode {
    public static void main(String[] args) {

    }

    public static TreeNode commonParentNode(TreeNode root, TreeNode a, TreeNode b){
        if(root==null||root==a||root==b){
            return root;
        }
        TreeNode left = commonParentNode(root.leftNode,a,b);
        TreeNode right = commonParentNode(root.rightNode, a,b);
        if(left!=null&&right!=null){
            return root;
        }
        else if(left!=null){
            return left;
        }
        else if(right!=null){
            return right;
        }else {
            return null;
        }
    }

}
