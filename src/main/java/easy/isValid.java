package easy;

import java.util.Scanner;
import java.util.Stack;

/**
 * 括号匹配
 */
public class isValid {
    private static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') st.push(')');
            else if (ss[i] == '[') st.push(']');
            else if (ss[i] == '{') st.push('}');
            else if (st.isEmpty() || st.peek() != ss[i]) return false;
            else st.pop();
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }
}
