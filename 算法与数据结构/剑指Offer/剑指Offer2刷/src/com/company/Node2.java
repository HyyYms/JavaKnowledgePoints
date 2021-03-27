package com.company;

/**
 * @program: 剑指Offer2刷
 * @description:
 * @author: Mr.Huang
 * @create: 2021-03-01 11:21
 **/
public class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val,Node2 _left,Node2 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
