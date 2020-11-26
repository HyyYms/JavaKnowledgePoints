package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: 设计支持增量操作的栈
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-26 15:53
 **/
public class CustomStack2 {

    int maxSize;
    List<Integer> list;

    public CustomStack2(int maxSize) {
        this.maxSize = maxSize;
        list = new ArrayList<>();
    }

    public void push(int x) {
        if (list.size() < maxSize) {
            list.add(x);
        }
    }

    public int pop() {
        return list.isEmpty() ? -1 : list.remove(list.size() - 1);
    }

    public void increment(int k, int val) {
        int length = k > list.size() ? list.size() : k;
        for (int j = 0; j < length; j++) {
            list.set(j, list.get(j) + val);
        }
    }
}
