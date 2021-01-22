package com.company;


/**
 * @program: 左叶子之和
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 17:38
 **/
public class Solution {

    int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (isLeaf(root.left)) {
                ans += root.left.val;
            } else {
                dfs(root.left);
            }
        }
        if (root.right != null && !isLeaf(root.right)) {
            dfs(root.right);
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
