package com.company;

/**
 * @program: 平衡二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-03 13:43
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
