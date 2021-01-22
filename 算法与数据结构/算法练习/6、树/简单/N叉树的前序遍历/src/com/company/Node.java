package com.company;

import java.util.List;

/**
 * @program: N叉树的前序遍历
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 14:03
 **/
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
