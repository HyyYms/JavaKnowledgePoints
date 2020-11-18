package com.company;
import	java.util.LinkedList;

import java.util.HashMap;

/**
 * @program: 删除未排序链表中的重复元素
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-18 15:17
 **/
public class Solution2 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode pre = new ListNode(0);
        ListNode result = pre;
        ListNode cur = head;
        while (cur != null) {
            if (!map.containsKey(cur.val)) {
                map.put(cur.val, cur);
                pre.next = new ListNode(cur.val);
                pre = pre.next;
            }
            cur = cur.next;
        }
        return result.next;
    }
}
