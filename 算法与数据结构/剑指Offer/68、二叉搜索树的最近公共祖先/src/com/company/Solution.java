package com.company;


/**
 * @program: 68_1、二叉搜索树的最近公共祖先
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-03 22:32
 **/
public class Solution {

    // 迭代
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else {
                break;
            }
        }
        return cur;
    }

    // 递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        return root;
    }
}
