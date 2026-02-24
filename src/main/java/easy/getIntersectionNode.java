package easy;

import java.util.Scanner;

/**
 * 相交链表
 */
public class getIntersectionNode {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
    }

    public static void main(String[] args) {
        /*//headA: 4->1->8->4->5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;*/

        Scanner sc = new Scanner(System.in);
        String[] split1 = sc.nextLine().split(" ");
        String[] split2 = sc.nextLine().split(" ");
        ListNode headA = new ListNode(Integer.parseInt(split1[0]));
        ListNode headB = new ListNode(Integer.parseInt(split2[0]));
        ListNode tmp1 = headA, tmp2 = headB;

        for (int i = 0; i < split1.length; i++) {
            tmp1.next = new ListNode(Integer.parseInt(split1[i]));
            tmp1 = tmp1.next;
        }
        for (int i = 0; i < split2.length; i++) {
            tmp2.next = new ListNode(Integer.parseInt(split2[i]));
            tmp2 = tmp2.next;
        }

        System.out.println(getIntersectionNode(headA, headB).val);
    }
}
