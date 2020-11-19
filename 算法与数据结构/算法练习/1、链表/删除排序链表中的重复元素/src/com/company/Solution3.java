package com.company;

import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: 删除排序链表中的重复元素
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-19 09:13
 **/
public class Solution3 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        HashMap<Integer, ListNode> map = new HashMap<>();
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            if (map.containsKey(cur.val)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).val == cur.val) {
                        list.remove(i);
                    }
                }
            } else {
                list.add(new ListNode(cur.val));
                map.put(cur.val, cur);
            }
            cur = cur.next;
        }
        
        if (list.isEmpty()) {
            return null;
        }

        ListNode result = list.get(0);
        ListNode node = result;
        for (int i = 1; i < list.size(); i++) {
            node.next = list.get(i);
            node = node.next;
        }
        return result;
    }

}
