package com.company.v1;

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
        return;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = new LinkedList<>();
        List<Integer> inorderList = new LinkedList<>();
        for (int i : preorder) {
            preorderList.add(i);
        }
        for (int i : inorder) {
            inorderList.add(i);
        }
        return helpTree(preorderList, inorderList);
    }

    public TreeNode helpTree(List<Integer> preorderList, List<Integer> inorderList) {
        if (inorderList.size() == 0) {
            return null;
        }
        Integer rootVal = preorderList.remove(0);
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderList.indexOf(rootVal);
        root.left = helpTree(preorderList, inorderList.subList(0, mid));
        root.right = helpTree(preorderList, inorderList.subList(mid + 1, inorderList.size()));
        return root;
    }
}
