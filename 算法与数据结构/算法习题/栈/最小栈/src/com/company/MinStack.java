package com.company;

import java.util.LinkedList;

import java.util.LinkedList;

/**
 * @program: 最小栈
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-27 12:13
 **/
public class MinStack {

    private LinkedList<Integer> stackA = null;
    private LinkedList<Integer> stackB = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackA = new LinkedList();
        stackB = new LinkedList();
    }

    public void push(int x) {
        stackA.push(x);
        if (stackB.size() == 0) {
            stackB.push(x);
        } else {
            if (stackB.peek() >= x) {
                stackB.push(x);
            }
        }
    }

    public void pop() {
        if (stackA.peek().equals(stackB.peek())){
            stackA.pop();
            stackB.pop();
        }else{
            stackA.pop();
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int getMin() {
        return stackB.peek();
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "stackA=" + stackA +
                ", stackB=" + stackB +
                '}';
    }
}
