package com.company;

/**
 * @program: 二叉树的序列化与反序列化
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-02 16:33
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
