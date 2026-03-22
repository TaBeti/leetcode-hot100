package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 电话号码的字母组合
 */
public class letterCombinations {
    private static List<String> res = new ArrayList<>();
    private static String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static StringBuilder sb = new StringBuilder();

    private static List<String> letterCombinations(String digits) {
        backtracking(digits, 0);
        return res;
    }

    private static void backtracking(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        System.out.println(letterCombinations(digits));
    }
}
