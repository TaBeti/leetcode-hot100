package hard;

import java.util.Scanner;

/**
 * 最小覆盖子串
 */
public class minWindow {
    private static String minWindow(String s, String t) {
        int m = s.length();
        int ansLeft = -1, ansRight = m;
        int[] cntS = new int[128], cntT = new int[128];
        for (char ch : t.toCharArray()) cntT[ch]++;
        int left = 0;
        char[] ss = s.toCharArray();
        for (int right = 0; right < m; right++) {
            cntS[ss[right]]++;
            while (isCovered(cntS, cntT)) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                cntS[ss[left]]--;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    public static boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'a'; i < 'z'; i++) {
            if (cntS[i] < cntT[i]) return false;
        }
        for (int i = 'A'; i < 'Z'; i++) {
            if (cntS[i] < cntT[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s, t));
    }
}
