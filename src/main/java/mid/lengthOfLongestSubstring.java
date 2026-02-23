package mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 无重复字符的最长子串
 */
public class lengthOfLongestSubstring {
    private static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) start = Math.max(start, map.get(ch));
            res = Math.max(res, end - start + 1);
            map.put(ch, end + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }
}
