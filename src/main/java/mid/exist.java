package mid;

import java.util.Scanner;

/**
 * 单词搜索
 */
public class exist {
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean dfs(int i, int j, int k, char[][] board, char[] word) {
        if (board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[i][j] = 0;
        for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && dfs(x, y, k + 1, board, word)) {
                return true;
            }
        }
        board[i][j] = word[k];
        return false;
    }

    private static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, w)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        String word = sc.nextLine();
        System.out.println(exist(board, word));
    }
}
