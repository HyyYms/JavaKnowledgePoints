package com.company;

import java.util.HashMap;

/**
 * @program: 链表组件
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-19 15:24
 **/
public class Solution {

    public int numComponents(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : G) {
            map.put(value, value);
        }

        int result = 0;
        while (head != null) {
            if (map.containsKey(head.val)) {
                result++;
                while (head.next != null) {
                    head = head.next;
                    if (!map.containsKey(head.val)) {
                        break;
                    }
                }
            }
            head = head.next;
        }
        return result;
    }
}
