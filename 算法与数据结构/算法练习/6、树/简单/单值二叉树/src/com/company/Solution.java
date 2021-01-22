package com.company;

/**
 * @program: 单值二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 17:32
 **/
public class Solution {


    int pre;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        pre = root.val;
        return help(root);
    }

    private boolean help(TreeNode root) {
        if (root == null) {
            return true;
        }
        return pre == root.val &&
                help(root.left) &&
                help(root.right);
    }
}
