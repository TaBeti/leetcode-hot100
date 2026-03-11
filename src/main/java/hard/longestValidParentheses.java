package hard;

import java.util.Scanner;

/**
 * 最长有效括号
 */
public class longestValidParentheses {
    private static int longestValidParentheses(String s) {
        int res = 0;
        int[] dp = new int[s.length()];
        char[] ss = s.toCharArray();
        for (int i = 1; i < ss.length; i++) {
            if (ss[i] == ')') {
                if (ss[i - 1] == '(') dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                else if (i - dp[i - 1] > 0 && ss[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longestValidParentheses(s));
    }
}
