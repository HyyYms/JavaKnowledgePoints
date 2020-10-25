package com.company;


/**
 * @program: 复制带随机指针的链表
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-25 23:26
 **/
public class Test {

    public static void main(String[] args) {
        // 空链表测试
        Node empty = null;
        Node emptyNode1 = Solution1.copyRandomList(empty);
        Node emptyNode2 = Solution2.copyRandomList(empty);
        System.out.println("空链表测试：");
        System.out.println("方法1：");
        show(emptyNode1);
        System.out.println("方法2：");
        show(emptyNode2);

        // 一个节点链表测试
        Node one = new Node(1);
        one.next = null;
        one.random = null;
        Node oneNode1 = Solution1.copyRandomList(one);
        Node oneNode2 = Solution2.copyRandomList(one);
        System.out.println("一个节点链表测试：");
        System.out.println("方法1：");
        show(oneNode1);
        System.out.println("方法2：");
        show(oneNode2);

        // 两个节点链表测试
        Node two = new Node(1);
        two.next = new Node(2);
        two.random = null;
        two.next.random = two;
        Node twoNode1 = Solution1.copyRandomList(two);
        Node twoNode2 = Solution2.copyRandomList(two);
        System.out.println("两个节点链表测试：");
        System.out.println("方法1：");
        show(twoNode1);
        System.out.println("方法2：");
        show(twoNode2);

        // 正常链表测试
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.random = list.next.next;
        list.next.random = list;
        list.next.next.random = null;
        list.next.next.next.random = list.next;
        Node listNode1 = Solution1.copyRandomList(list);
        Node listNode2 = Solution2.copyRandomList(list);
        System.out.println("正常链表测试：");
        System.out.println("方法1：");
        show(listNode1);
        System.out.println("方法2：");
        show(listNode2);
    }

    private static void show(Node node) {
        while (node != null) {
            System.out.println("数值：" + node.val);
            if (node.next != null) {
                System.out.println("下一节点数值：" + node.next.val);
            } else {
                System.out.println("下一节点数值：" + null);
            }
            if (node.random != null) {
                System.out.println("随机节点数值：" + node.random.val);
            } else {
                System.out.println("随机节点数值：" + null);
            }
            node = node.next;
        }
    }
}
