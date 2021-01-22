package com.company;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: 根据二叉树创建字符串
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-22 15:23
 **/
public class Solution {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}
