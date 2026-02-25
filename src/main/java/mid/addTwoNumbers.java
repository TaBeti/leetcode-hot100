package mid;

import java.util.Scanner;

/**
 * 两数相加
 */
public class addTwoNumbers {
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

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cur = cur.next = new ListNode(carry % 10);
            carry /= 10;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split1 = sc.nextLine().split(" ");
        String[] split2 = sc.nextLine().split(" ");
        ListNode list1 = new ListNode(Integer.parseInt(split1[0]));
        ListNode l1 = list1;
        for (int i = 1; i < split1.length; i++) {
            l1.next = new ListNode(Integer.parseInt(split1[i]));
            l1 = l1.next;
        }
        ListNode list2 = new ListNode(Integer.parseInt(split2[0]));
        ListNode l2 = list2;
        for (int i = 1; i < split2.length; i++) {
            l2.next = new ListNode(Integer.parseInt(split2[i]));
            l2 = l2.next;
        }
        ListNode res = addTwoNumbers(list1, list2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
