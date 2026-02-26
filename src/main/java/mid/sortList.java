package mid;

import java.util.Scanner;

/**
 * 排序链表
 */
public class sortList {
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

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode head2 = middleNode(head);
        head = sortList(head);
        head2 = sortList(head2);
        return mergeTwoLists(head, head2);
    }

    private static ListNode middleNode(ListNode head) {
        ListNode pre = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
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
        ListNode res = sortList(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
