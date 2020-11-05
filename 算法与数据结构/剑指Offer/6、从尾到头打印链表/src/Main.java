import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: 从尾到头打印链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-14 22:29
 **/

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
//        示例 1：
//
//        输入：head = [1,3,2]
//        输出：[2,3,1]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

// 无读题，不知道ListNode的结构，私自定义

public class Main {
    public static void main(String[] args) {
        MyListNode head = new MyListNode();
        MyListNode head2 = new MyListNode();
        MyListNode head3 = new MyListNode();

        head.setData(1);
        head2.setData(3);
        head3.setData(2);

        head.setNext(head2);
        head2.setNext(head3);
        int[] ints = myReversePrint(head);
        System.out.println(ints);
    }

    public static int[] myReversePrint(MyListNode head) {
        int[] res = null;
        MyListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null) {
            stack.push(fast.getData());
            fast = fast.getNext();
        }
        int i = 0;
        res = new int[stack.size()];
        while (!stack.empty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }

    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }

}
