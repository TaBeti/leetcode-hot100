package mid;

import java.util.*;

/**
 * 验证二叉搜索树
 */
public class isValidBST {
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

    private static List<Integer> nums = new ArrayList<>();

    private static boolean isValidBST(TreeNode root) {
        traversal(root);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) <= nums.get(i - 1)) return false;
        }
        return true;
    }

    private static void traversal(TreeNode node) {
        if (node == null) return;
        traversal(node.left);
        nums.add(node.val);
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
        boolean res = isValidBST(root);
        System.out.println(res);
    }
}
