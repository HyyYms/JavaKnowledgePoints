package com.company;

import java.util.LinkedList;

/**
 * @program: 用栈实现队列
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-27 15:11
 **/
public class MyQueue {

    private LinkedList<Integer> stackA;
    private LinkedList<Integer> stackB;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackA.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stackB.size() == 0) {
            while (stackA.size() != 0) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stackB.size() == 0) {
            while (stackA.size() != 0) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackA.size() == 0 && stackB.size() == 0;
    }
}
