package com.company;

import java.util.LinkedList;

/**
 * @program: 设计支持增量操作的栈
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-26 15:53
 **/
public class CustomStack {

    int maxSize;
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        if (stack1.size() < maxSize) {
            stack1.push(x);
        }
    }

    public int pop() {
        return stack1.isEmpty() ? -1 : stack1.pop();
    }

    public void increment(int k, int val) {
        if (stack1.size() < k) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop() + val);
            }
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        } else {
            LinkedList<Integer> stack3 = new LinkedList<>();
            while (stack1.size() != k) {
                stack3.push(stack1.pop());
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop() + val);
            }
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            while (!stack3.isEmpty()) {
                stack1.push(stack3.pop());
            }
        }
    }
}
