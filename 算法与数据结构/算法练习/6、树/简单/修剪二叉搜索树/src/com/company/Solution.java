package com.company;

/**
 * @program: 修剪二叉搜索树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 17:55
 **/
public class Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
