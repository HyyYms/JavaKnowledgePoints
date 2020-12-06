package com.company;

import java.util.LinkedList;

/**
 * @program: 54、二叉搜索树的第K大节点
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-06 16:00
 **/
public class Solution {


    // 使用递归
    int k;
    int res;

    public int kthLargest2(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        this.k = k;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null || k == 0) {
            return;
        }
        helper(root.right);
        if (--k == 0) {
            res = root.val;
            return;
        }
        helper(root.left);
    }

    // 不用递归
    public int kthLargest1(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        int num = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            num = root.val;
            k--;
            if (k == 0) {
                break;
            }
            root = root.left;
        }
        return num;
    }
}
