package com.company;

import java.util.LinkedList;

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

        TreeNode cur = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(A);
        while (!stack.isEmpty()) {
            if (stack.peek().val == B.val) {
                cur = stack.pop();
                break;
            }
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        LinkedList<TreeNode> stackA = new LinkedList<>();
        LinkedList<TreeNode> stackB = new LinkedList<>();
        stackA.push(cur);
        stackB.push(B);

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek().val != stackB.peek().val) {
                return false;
            }
            cur = stackA.pop();
            if (cur.right != null) {
                stackA.push(cur.right);
            }
            if (cur.left != null) {
                stackA.push(cur.left);
            }
            B = stackB.pop();
            if (B.right != null) {
                stackB.push(B.right);
            }
            if (B.left != null) {
                stackB.push(B.left);
            }
        }
        return stackB.isEmpty();
    }
}
