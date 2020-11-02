package com.company;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: 二叉树的序列化与反序列化
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-02 16:32
 **/
public class Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        String serialize = new Codec().serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = new Codec().deserialize(serialize);
        System.out.println(deserialize);

        String serialize1 = new Codec().serialize(root1);
        System.out.println(serialize1);
        TreeNode deserialize1 = new Codec().deserialize(serialize1);
        System.out.println(deserialize1);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        List<TreeNode> list = new ArrayList<>();
        // list: {1,2,3,null,null,4,5,null,null,null,null}
        list.add(root);
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (null == node) {
                continue;
            }
            list.add(node.left);
            list.add(node.right);
        }
        // list：{1，2，3，null,null,4,5}
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        // sb：{1，2，3，#，#，4，5}
        StringBuilder sb = new StringBuilder("{");
        sb.append(list.get(0).val);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",").append(list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "{}".equals(data)) {
            return null;
        }
        String[] datas = data.substring(1, data.length() - 1).split(",");
        boolean isLeft = true;
        int index = 0;
        List<TreeNode> queue = new ArrayList<>();
        TreeNode node = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(node);
        for (int i = 1; i < datas.length; i++) {
            if (!("#").equals(datas[i])) {
                TreeNode node1 = new TreeNode(Integer.parseInt(datas[i]));
                if (isLeft) {
                    queue.get(index).left = node1;
                } else {
                    queue.get(index).right = node1;
                }
                queue.add(node1);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return queue.get(0);
    }

}

