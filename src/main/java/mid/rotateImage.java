package mid;

import java.util.Arrays;
import java.util.Scanner;

public class rotateImage {
    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int[] row : matrix) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = row[j];
                row[j] = row[n - j - 1];
                row[n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        rotate(matrix);
        for (int[] mx : matrix) {
            System.out.print(Arrays.toString(mx) + " ");
        }
    }
}
