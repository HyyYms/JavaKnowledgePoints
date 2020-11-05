package com.company.v2;


import java.util.LinkedList;
import java.util.List;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//         
//
//        例如，给出
//
//        前序遍历 preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]
//        返回如下的二叉树：
//
//        3
//        / \
//        9  20
//        /  \
//        15   7

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class Main {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helpTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helpTree(int preStart, int inStart, int inEnd,
                             int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        int index = 0;
        Integer rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        for (int i = inStart; i < inEnd; i++) {
            if (preorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        root.left = helpTree(preStart + 1, inStart,
                index - 1, preorder, inorder);
        root.right = helpTree(preStart + index - inStart + 1, index + 1,
                inEnd, preorder, inorder);
        return root;
    }
}
