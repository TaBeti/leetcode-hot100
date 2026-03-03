package mid;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 腐烂的橘子
 */
public class orangesRotting {
    private static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private static int orangesRotting(int[][] grid) {
        int minutes = -1, freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) freshCount++;
                else if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        if (freshCount == 0) return 0;
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int[] d : dir) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        freshCount--;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return freshCount > 0 ? -1 : minutes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(orangesRotting(grid));
    }
}
