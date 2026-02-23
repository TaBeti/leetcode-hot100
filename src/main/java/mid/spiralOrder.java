package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 螺旋矩阵
 */
public class spiralOrder {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        int i = 0, j = 0, di = 0;
        for (int k = 0; k < m * n; k++) {
            res.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE;
            int x = i + dirs[di][0], y = j + dirs[di][1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == Integer.MAX_VALUE) {
                di = (di + 1) % 4;
            }
            i += dirs[di][0];
            j += dirs[di][1];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(spiralOrder(matrix));
    }
}
