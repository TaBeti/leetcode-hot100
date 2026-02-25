package mid;

import java.util.Scanner;

/**
 * 合并两个有序链表
 */
public class mergeTwoLists {
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
        String[] split1 = sc.nextLine().split(" ");
        String[] split2 = sc.nextLine().split(" ");
        ListNode list1 = new ListNode(Integer.parseInt(split1[0]));
        ListNode list2 = new ListNode(Integer.parseInt(split2[0]));
        ListNode tmp1 = list1, tmp2 = list2;
        for (int i = 1; i < split1.length; i++) {
            tmp1.next = new ListNode(Integer.parseInt(split1[i]));
            tmp1 = tmp1.next;
        }
        for (int i = 1; i < split2.length; i++) {
            tmp2.next = new ListNode(Integer.parseInt(split2[i]));
            tmp2 = tmp2.next;
        }
        ListNode res = mergeTwoLists(list1, list2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
