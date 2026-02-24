package easy;

import java.util.Scanner;

/**
 * 反转链表
 */
public class reverseList {
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

    private static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
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
        ListNode reverseHead = reverseList(head);
        while (reverseHead != null) {
            System.out.print(reverseHead.val + " ");
            reverseHead = reverseHead.next;
        }
    }
}
