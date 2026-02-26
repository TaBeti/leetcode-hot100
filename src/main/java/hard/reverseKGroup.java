package hard;

import java.util.Scanner;

/**
 * k个一组反转链表
 */
public class reverseKGroup {
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

    private static ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) n++;
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy, cur = head, pre = null;
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
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
        int k = sc.nextInt();
        ListNode res = reverseKGroup(head, k);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
