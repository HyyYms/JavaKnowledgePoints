package com.company;

import java.util.Deque;

import java.util.LinkedList;

/**
 * @program: 队列的最大值
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-26 17:33
 **/
public class MaxQueue {

    Deque<Integer> queue;
    Deque<Integer> help;

    public MaxQueue() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public int max_value() {
        return help.isEmpty() ? -1 : help.peekFirst();
    }

    public void push_back(int value) {
        queue.offerLast(value);
        while (!help.isEmpty() && help.peekLast() < value) {
            help.pollLast();
        }
        help.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int val = queue.pollFirst();
        if (val == help.peekFirst()) {
            help.pollFirst();
        }
        return val;
    }
}
