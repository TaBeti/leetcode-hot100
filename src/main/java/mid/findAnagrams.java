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
        int[] cntS = new int[26], cntP = new int[26];
        for (char c : pp) cntP[c - 'a']++;
        for (int start = 0, end = 0; end < m; end++) {
            cntS[ss[end] - 'a']++;
            if (end - start + 1 > n) {
                cntS[ss[start] - 'a']--;
                start++;
            }
            if (check(cntS, cntP)) res.add(start);
        }
        return res;
    }

    private static boolean check(int[] c1, int[] c2) {
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
