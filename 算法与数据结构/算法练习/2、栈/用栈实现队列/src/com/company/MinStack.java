package com.company;

import java.util.LinkedList;

/**
 * @program: 栈的最小值
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-23 11:18
 **/
public class MinStack {

    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else if (stack1.peek() <= stack2.peek()) {
            stack2.push(stack1.peek());
        }
    }

    public void pop() {
        if (stack1.peek().equals(stack2.peek())) {
            stack2.pop();
            stack1.pop();
        } else {
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
