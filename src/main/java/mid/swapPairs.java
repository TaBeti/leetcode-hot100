package mid;

import java.util.Scanner;

/**
 * 两两交换链表中的节点
 */
public class swapPairs {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode node0 = dummy, node1 = head;
        while (node1 != null && node1.next != null) {
            ListNode node2 = node1.next, node3 = node2.next;
            node0.next = node2;
            node2.next = node1;
            node1.next = node3;

            node0 = node1;
            node1 = node3;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode tmp = head;
        for (int i = 1; i < split.length; i++) {
            tmp.next = new ListNode(Integer.parseInt(split[i]));
            tmp = tmp.next;
        }
        ListNode res = swapPairs(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
