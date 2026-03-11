package mid;

import java.util.Scanner;

/**
 * 最长回文子串
 */
public class longestPalindrome {
    private static String longestPalindrome(String s) {
        int n = s.length();
        char[] ss = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        int start = 0, maxLen = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (ss[i] == ss[j]) {
                    if (j - i <= 1) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longestPalindrome(s));
    }
}
