package com.company;

/**
 * @program: 递增顺序查找树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 14:20
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
