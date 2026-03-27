package mid;

import java.util.*;

/**
 * 路径总和III
 */
public class pathSum {
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

    private static int res = 0;
    private static Map<Long, Integer> map = new HashMap<>();

    private static int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        dfs(root, 0, targetSum);
        return res;
    }

    private static void dfs(TreeNode node, long curSum, int targetSum) {
        if (node == null) return;
        curSum += node.val;
        res += map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        dfs(node.left, curSum, targetSum);
        dfs(node.right, curSum, targetSum);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);
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
        int targetSum = sc.nextInt();
        System.out.println(pathSum(root, targetSum));
    }
}
