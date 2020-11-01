package com.company;

/**
 * @program: 树的后序遍历
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-01 20:34
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
