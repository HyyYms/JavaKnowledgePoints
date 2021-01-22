package com.company;

import java.util.ArrayList;

import java.util.List;

/**
 * @program: 递增顺序查找树
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 14:20
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode node = new Solution().increasingBST(root);
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        List<Integer> result = preorder(root);
        TreeNode pre = new TreeNode();
        TreeNode cur = pre;
        for (Integer num : result) {
            cur.right = new TreeNode(num);
            cur = cur.right;
        }
        return pre.right;
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> left = preorder(root.left);
        List<Integer> right = preorder(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }
}
