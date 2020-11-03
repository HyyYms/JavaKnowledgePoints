package com.company;


import java.util.LinkedList;

/**
 * @program: 平衡二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-03 13:43
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(8);
        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return maxTree(root) != -1;
    }

    private static int maxTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxTree(node.left);
        int right = maxTree(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

}
