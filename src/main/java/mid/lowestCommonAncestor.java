package mid;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 二叉树的最近公共祖先
 */
public class lowestCommonAncestor {
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

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
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

    //本题由于p，q是作为节点输入，所以要写这么一个函数
    //可以根据传入的树根节点和值，来找到对应的节点
    private static TreeNode findNode(TreeNode node, int val) {
        if (node == null || node.val == val) return node;
        TreeNode left = findNode(node.left, val);
        TreeNode right = findNode(node.right, val);
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        TreeNode root = buildTree(split);
        int pVal = sc.nextInt(), qVal = sc.nextInt();
        TreeNode p = findNode(root, pVal), q = findNode(root, qVal);
        TreeNode res = lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }
}
