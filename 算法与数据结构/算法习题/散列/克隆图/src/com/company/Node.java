package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 克隆图
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-06 20:39
 **/
public class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
