package com.company;

import java.util.LinkedList;

/**
 * @program: 两个栈实现队列
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 22:16
 **/
public class CQueue {
    LinkedList<Integer> insertList;
    LinkedList<Integer> deleteList;

    public CQueue() {
        insertList = new LinkedList();
        deleteList = new LinkedList();
    }

    public void appendTail(int value) {
        insertList.push(value);
    }

    public int deleteHead() {
        if (deleteList.size() == 0) {
            while (insertList.size() != 0) {
                deleteList.push(insertList.pop());
            }
        }
        if (deleteList.size() == 0) {
            return -1;
        } else {
            return deleteList.pop();
        }
    }

    // 使用isEmpty()性能更高，运行时间更短
//    public int deleteHead() {
//        if (deleteList.isEmpty()) {
//            while (!insertList.isEmpty()) {
//                deleteList.push(insertList.pop());
//            }
//        }
//        if (deleteList.isEmpty()) {
//            return -1;
//        } else {
//            return deleteList.pop();
//        }
//    }
}
