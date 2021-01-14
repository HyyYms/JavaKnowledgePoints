package com.company;

import java.util.LinkedList;

/**
 * @program: 最近的请求次数
 * @description:
 * @author: Mr.Huang
 * @create: 2021-01-14 14:51
 **/
public class RecentCounter {

    LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        int temp = t - 3000;
        while (queue.size() != 0 && queue.peek() < temp) {
            queue.poll();
        }
        return queue.size();
    }
}
