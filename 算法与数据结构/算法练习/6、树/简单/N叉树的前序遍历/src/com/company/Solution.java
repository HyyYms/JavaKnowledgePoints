package com.company;

import java.util.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: N叉树的前序遍历
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 14:04
 **/
public class Solution {

    // 迭代
    public List<Integer> preorder2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                Node child = node.children.get(i);
                if (child != null) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return result;
    }

    // 递归
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        for (Node child : root.children) {
            List<Integer> list = preorder1(child);
            result.addAll(list);
        }
        return result;
    }
}
