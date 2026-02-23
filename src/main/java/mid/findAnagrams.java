package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 找到字符串中所有字母异位词
 */
public class findAnagrams {
    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] ss = s.toCharArray(), pp = p.toCharArray();
        int m = ss.length, n = pp.length;
        int[] c1 = new int[26], c2 = new int[26];
        for (char ch : pp) c2[ch - 'a']++;
        for (int start = 0, end = 0; end < m; end++) {
            c1[ss[end] - 'a']++;
            if (end - start + 1 > n) {
                c1[ss[start] - 'a']--;
                start++;
            }
            if (check(c1, c2)) res.add(start);
        }
        return res;
    }

    public static boolean check(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(findAnagrams(s, p));
    }
}
