package com.company;

import java.util.LinkedList;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: 二叉树的右视角
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-02 23:20
 **/
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean findRight = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            findRight = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!findRight) {
                    result.add(node.val);
                    findRight = true;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return result;
    }
}
