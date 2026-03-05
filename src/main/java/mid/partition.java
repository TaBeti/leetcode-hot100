package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 分割回文串
 */
public class partition {
    private static List<List<String>> res = new ArrayList<>();
    private static List<String> path = new ArrayList<>();

    private static List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    private static void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(partition(s));
    }
}
