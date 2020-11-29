package com.company;


/**
 * @program: 28、对称的二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-29 11:40
 **/
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return recurse(root.left, root.right);
    }

    private boolean recurse(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recurse(left.right, right.left) && recurse(left.left, right.right);
    }
}
