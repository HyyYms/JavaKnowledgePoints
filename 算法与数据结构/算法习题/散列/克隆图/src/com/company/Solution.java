package com.company;


import java.util.*;

/**
 * @program: 克隆图
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-06 20:39
 **/
public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList<Node> list = getNodeList(node);
        Map<Node, Node> mapping = new HashMap<>();
        // 克隆node
        for (Node n : list) {
            mapping.put(n, new Node(n.val));
        }
        // 克隆neighbors
        for (Node n : list) {
            Node newNode = mapping.get(n);
            for (Node neighbor : n.neighbors) {
                Node newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }

    private ArrayList<Node> getNodeList(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            for (Node neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
