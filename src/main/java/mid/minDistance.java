package mid;

import java.util.Scanner;

/**
 * 编辑距离
 */
public class minDistance {
    private static int minDistance(String word1, String word2) {
        char[] char1 = word1.toCharArray(), char2 = word2.toCharArray();
        int m = char1.length, n = char2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (char1[i - 1] == char2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine(), word2 = sc.nextLine();
        System.out.println(minDistance(word1, word2));
    }
}
