package mid;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 二叉搜索树中第 K小的元素
 */
public class kthSmallest {
    private static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int k;
    private static int res;

    private static int kthSmallest(TreeNode root, int k) {
        kthSmallest.k = k;
        traversal(root);
        return res;
    }

    private static void traversal(TreeNode node) {
        if (node == null) return;
        traversal(node.left);
        if (--k == 0) res = node.val;
        traversal(node.right);
    }

    private static TreeNode buildTree(String[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode cur = queue.poll();
            if (index < nodes.length && !nodes[index].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.left);
            }
            index++;
            if (index < nodes.length && !nodes[index].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        TreeNode root = buildTree(split);
        int k = sc.nextInt();
        System.out.println(kthSmallest(root, k));
    }
}
