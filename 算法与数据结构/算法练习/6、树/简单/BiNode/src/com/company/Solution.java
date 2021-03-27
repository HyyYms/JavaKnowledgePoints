package com.company;

/**
 * @program: BiNode
 * @description:
 * @author: Mr.Huang
 * @create: 2021-02-02 14:29
 **/
public class Solution {

    TreeNode head = new TreeNode(-1);
    TreeNode pre = null;
    public TreeNode convertBiNode(TreeNode root) {
        help(root);
        return head;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (pre == null) {
            head = root;
            pre = root;
        }else {
            pre.right = root;
            pre = root;
        }
        pre.left = null;
        help(root.right);
    }
}
