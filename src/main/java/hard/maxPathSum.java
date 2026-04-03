package hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 二叉树的最大路径和
 */
public class maxPathSum {
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

    private static int res = Integer.MIN_VALUE;

    private static int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        res = Math.max(res, left + right + node.val);
        return Math.max(Math.max(left, right) + node.val, 0);
    }

    private static int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
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
        System.out.println(maxPathSum(root));
    }
}
