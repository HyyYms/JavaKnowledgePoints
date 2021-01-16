package com.company;

/**
 * @program: 二叉树的坡度
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-16 15:32
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
