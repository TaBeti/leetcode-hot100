package hard;

import java.util.Scanner;

/**
 * 合并K个升序链表
 */
public class mergeKLists {
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

    private static ListNode mergeTwolists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        for (int step = 1; step < n; step *= 2) {
            for (int i = 0; i < n - step; i += step * 2) {
                lists[i] = mergeTwolists(lists[i], lists[i + step]);
            }
        }
        return lists[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ListNode[] lists = new ListNode[n];
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            lists[i] = new ListNode(Integer.parseInt(split[0]));
            ListNode tmp = lists[i];
            for (int j = 1; j < split.length; j++) {
                tmp.next = new ListNode(Integer.parseInt(split[j]));
                tmp = tmp.next;
            }
        }
        ListNode res = mergeKLists(lists);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
