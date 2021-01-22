package com.company;

/**
 * @program: 合并二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 15:37
 **/
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
