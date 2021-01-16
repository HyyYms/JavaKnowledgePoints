package com.company;

/**
 * @program: 另一个树的子树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-14 17:10
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
