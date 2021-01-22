package com.company;

/**
 * @program: 路径总和
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 15:07
 **/
public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
