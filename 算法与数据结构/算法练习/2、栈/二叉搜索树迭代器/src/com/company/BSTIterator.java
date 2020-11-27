package com.company;

import java.util.ArrayList;


import java.util.LinkedList;
import java.util.List;

/**
 * @program: 二叉搜索树迭代器
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-27 10:21
 **/
public class BSTIterator {

    TreeNode cur;
    LinkedList<TreeNode> stack;
    List<Integer> list;

    public BSTIterator(TreeNode root) {
        this.cur = root;
        stack = new LinkedList<>();
        list = new ArrayList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            cur = pop.right;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.remove(0);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !list.isEmpty();
    }
}
