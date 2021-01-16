package com.company;


/**
 * @program: 二叉树的坡度
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-16 15:32
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        new Solution().findTilt(root);
    }

    int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root);
        return res;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = help(root.left);
        int rightNum = help(root.right);
        res += Math.abs(leftNum - rightNum);
        return root.val + leftNum + rightNum;
    }
}
