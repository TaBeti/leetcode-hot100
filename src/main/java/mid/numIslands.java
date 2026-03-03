package mid;

import java.util.Scanner;

public class numIslands {
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
            if (!visited[nextx][nexty] && grid[nextx][nexty] == '1') {
                visited[nextx][nexty] = true;
                dfs(grid, visited, nextx, nexty);
            }
        }
    }

    private static int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), cols = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        System.out.println(numIslands(grid));
    }
}
