package com.company;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: 下一个更大元素
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-25 11:19
 **/
public class Solution3 {

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(1);
        node.next.next = new ListNode(5);
        new Solution3().nextLargerNodes2(node);
    }

    // 改进我的解法——Stack结合List
    public int[] nextLargerNodes5(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<Integer>();
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            while (!stack.isEmpty() && head.val > list.get(stack.peek())) {
                list.set(stack.pop(), head.val);
            }
            stack.push(list.size());
            list.add(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            list.set(stack.pop(), 0);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // 剪枝，从后往前运算
    public int[] nextLargerNodes4(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] result = new int[list.size()];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            int j = i + 1;
            if (j >= list.size()) {
                continue;
            }
            Integer num = list.get(j);
            while (j < list.size()) {
                if (num > list.get(i)) {
                    result[i] = num;
                    break;
                } else if (num == 0) {
                    break;
                } else {
                    num = result[j++];
                }
            }
        }
        return result;
    }

    // 利用栈进行存储数据的下标，从而进行比较；栈为单调栈，从栈底至栈顶递减
    public int[] nextLargerNodes3(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] result = new int[list.size()];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return result;
    }

    // 暴力解法
    public int[] nextLargerNodes2(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) > list.get(i)) {
                    result[i] = list.get(j);
                    break;
                }
            }
        }
        return result;
    }

    // 我的解法——Stack结合Map
    public int[] nextLargerNodes1(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        cur = head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        LinkedList<ListNode> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                map.put(stack.pop(), cur.val);
            }
            stack.push(cur);
            cur = cur.next;
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            Integer num = map.getOrDefault(head, 0);
            result[i] = num;
            head = head.next;
        }
        return result;
    }
}
