package com.company;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: 合并K个升序链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-20 15:33
 **/
public class Solution {

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists4(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftNode = merge(lists, left, mid);
        ListNode rightNode = merge(lists, mid + 1, right);
        return mergeLists(leftNode, rightNode);
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = null;
        for (ListNode list : lists) {
            result = mergeLists(result, list);
        }
        return result;
    }

    private ListNode mergeLists(ListNode nodeA, ListNode nodeB) {
        if (nodeA == null || nodeB == null) {
            return nodeA == null ? nodeB : nodeA;
        }
        ListNode pre = new ListNode();
        ListNode result = pre;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val < nodeB.val) {
                pre.next = nodeA;
                nodeA = nodeA.next;
            } else {
                pre.next = nodeB;
                nodeB = nodeB.next;
            }
            pre = pre.next;
        }
        if (nodeA != null) {
            pre.next = nodeA;
        }
        if (nodeB != null) {
            pre.next = nodeB;
        }
        return result.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0 || judgeLists(lists)) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (Integer num : list) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }

    private boolean judgeLists(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }
}
