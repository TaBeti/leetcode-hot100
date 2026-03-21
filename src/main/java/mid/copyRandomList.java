package mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 随机链表的复制
 */
public class copyRandomList {
    private static class Node {
        int val;
        Node next, random;
        Node() {}
        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private static Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node newNode = map.get(cur);
            if (cur.next != null) newNode.next = map.get(cur.next);
            if (cur.random != null) newNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    private static void printList(Node head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        // 1. 先遍历一遍，把每个节点对象对应的索引存起来
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            nodeToIndex.put(tmp, index++);
            tmp = tmp.next;
        }
        // 2. 开始按题目要求的格式打印 [[val, random_index], ...]
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        while (cur != null) {
            sb.append("[");
            sb.append(cur.val);
            sb.append(", ");
            // 从 Map 中查出 random 指向的节点对应的索引
            Integer randomIndex = nodeToIndex.get(cur.random);
            sb.append(randomIndex == null ? "null" : randomIndex);
            sb.append("]");
            if (cur.next != null) sb.append(", ");
            cur = cur.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Integer[][] input = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        // 1. 先创建所有节点并存入数组/列表，方便后面按索引找 random
        Node[] nodes = new Node[input.length];
        for (int i = 0; i < input.length; i++) nodes[i] = new Node(input[i][0]);
        // 2. 建立 next 和 random 指向
        for (int i = 0; i < input.length; i++) {
            if (i < input.length - 1) nodes[i].next = nodes[i + 1];
            if (input[i][1] != null) nodes[i].random = nodes[input[i][1]];
        }
        Node head = nodes[0];
        Node res = copyRandomList(head);
        printList(res);
    }
}
