package mid;

import java.util.Scanner;

/**
 * 最长公共子序列
 */
public class longestCommonSubsequence {
    private static int longestCommonSubsequence(String text1, String text2) {
        char[] char1 = text1.toCharArray(), char2 = text2.toCharArray();
        int m = char1.length, n = char2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (char1[i - 1] == char2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine(), text2 = sc.nextLine();
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
