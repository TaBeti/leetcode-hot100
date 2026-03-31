package easy;

import java.util.Scanner;

/**
 * 相交链表
 */
public class getIntersectionNode {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
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
        Scanner sc = new Scanner(System.in);
        // 1.构建链表
        String[] split1 = sc.nextLine().split(" ");
        ListNode headA = new ListNode(Integer.parseInt(split1[0]));
        ListNode l1 = headA;
        for (int i = 1; i < split1.length; i++) {
            l1.next = new ListNode(Integer.parseInt(split1[i]));
            l1 = l1.next;
        }
        String[] split2 = sc.nextLine().split(" ");
        ListNode headB = new ListNode(Integer.parseInt(split2[0]));
        ListNode l2 = headB;
        for (int i = 1; i < split2.length; i++) {
            l2.next = new ListNode(Integer.parseInt(split2[i]));
            l2 = l2.next;
        }
        //2.输入相交点
        int skipA = sc.nextInt();
        if (skipA != -1) {
            //找到 A 中的相交点
            ListNode intersectNode = headA;
            for (int i = 0; i < skipA; i++) intersectNode = intersectNode.next;
            //把 B 的末尾连上去
            if (headB != null) {
                headB = intersectNode;
            } else {
                ListNode tmp = headB;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = intersectNode;
            }
        }
        ListNode res = getIntersectionNode(headA, headB);
        if (res != null) System.out.println("Intersected at " + res.val);
        else System.out.println("No intersection");
    }

}
