package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 括号生成
 */
public class generateParenthesis {
    private static List<String> res = new ArrayList<>();

    private static List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return res;
    }

    private static void dfs(String path, int left, int right, int n) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        if (left < n) dfs(path + "(", left + 1, right, n);
        if (right < left) dfs(path + ")", left, right + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(generateParenthesis(n));
    }
}
