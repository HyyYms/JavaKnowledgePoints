package com.company;

/**
 * @program: 百度笔试
 * @description:
 * @author: Mr.Huang
 * @create: 2021-03-21 21:13
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
