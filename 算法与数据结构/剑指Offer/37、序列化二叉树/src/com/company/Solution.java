package com.company;


import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: 37、序列化二叉树
 * @description:
 * @author: Mr.Huang
 * @create: 2020-12-02 10:54
 **/
public class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
        String str = new Solution().serialize(node);
        new Solution().deserialize(str);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("[");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    list.add(poll.val + "");
                } else {
                    list.add("null");
                }
                if (poll != null) {
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
        }
        while ("null".equals(list.get(list.size() - 1))) {
            list.remove(list.size() - 1);
        }
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(",").append(list.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "[]".equals(data)) {
            return null;
        }
        String[] dataArr = data.substring(1, data.length() - 1).split(",");
        int index = 0;
        boolean isLeft = true;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        queue.offer(root);
        for (int i = 1; i < dataArr.length; i++) {
            if (!"null".equals(dataArr[i])) {
                TreeNode node = new TreeNode(Integer.parseInt(dataArr[i]));
                if (isLeft) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.offer(node);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return queue.get(0);
    }
}
