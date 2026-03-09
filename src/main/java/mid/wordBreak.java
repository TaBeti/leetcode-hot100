package mid;

import java.util.*;

/**
 * 单词拆分
 */
public class wordBreak {
    private static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) dp[i] = true;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = sc.nextLine().split(" ");
        List<String> wordDict = new ArrayList<>();
        wordDict.addAll(Arrays.asList(split));
        System.out.println(wordBreak(s, wordDict));
    }
}
