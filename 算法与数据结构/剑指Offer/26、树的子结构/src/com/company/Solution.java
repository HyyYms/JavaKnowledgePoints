package com.company;


/**
 * @program: 26、树的子结构
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-28 16:01
 **/
public class Solution {
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode(1);
        nodeA.left = new TreeNode(2);
        nodeA.right = new TreeNode(3);
        TreeNode nodeB = new TreeNode(3);
        System.out.println(
                new Solution().isSubStructure(nodeA, nodeB)
        );
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
