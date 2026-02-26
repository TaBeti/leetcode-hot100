package mid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 随机链表的复制
 */
public class copyRandomList {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private static Node copyRandomList(Node head) {
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

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = head.next = new Node(2);
        head.random = node2;
        node2.next = null;
        node2.random = node2;
        Node res = copyRandomList(head);
        while (res != null) {
            if (res.next == null) res.val = 0;
            System.out.print(res.val + ", " + res.random.val + " ");
            System.out.println();
            res = res.next;
        }
    }
}
