package com.company;

/**
 * @program: 从根到叶的二进制数之和
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 15:15
 **/
public class Solution {
    int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        help(root, 0);
        return ans;
    }

    public void help(TreeNode root, Integer cur) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans += cur * 2 + root.val;
            return;
        }
        help(root.left, cur * 2 + root.val);
        help(root.right, cur * 2 + root.val);
    }

}
