package com.company;

/**
 * @program: 翻转二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 16:10
 **/
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
