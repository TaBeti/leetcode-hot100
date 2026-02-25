package mid;

import java.util.Scanner;

/**
 * 环形链表II
 */
public class detectCycle {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != head) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
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
        int pos = sc.nextInt();
        if (pos != -1) {
            ListNode lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            ListNode cycleNode = head;
            for (int i = 0; i < pos; i++) {
                cycleNode = cycleNode.next;
            }
            lastNode.next = cycleNode;
        }
        ListNode res = detectCycle(head);
        System.out.println(res != null ? res.val : null);
    }
}
