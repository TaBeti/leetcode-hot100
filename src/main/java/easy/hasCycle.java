package easy;

import java.util.Scanner;

public class hasCycle {
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

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        //1.构建链表
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode tmp = head;
        for (int i = 1; i < split.length; i++) {
            tmp.next = new ListNode(Integer.parseInt(split[i]));
            tmp = tmp.next;
        }
        //2.获取环的位置并构建环
        int pos = sc.nextInt();
        if (pos != -1) {
            ListNode lastNode = head;
            //先找到末尾节点
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            //再找到环的位置，然后让末尾节点的next指向环的入口节点
            ListNode cycleNode = head;
            for (int i = 0; i < pos; i++) {
                cycleNode = cycleNode.next;
            }
            lastNode.next = cycleNode;
        }
        System.out.println(hasCycle(head));
    }
}
