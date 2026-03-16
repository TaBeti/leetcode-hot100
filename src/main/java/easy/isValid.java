package easy;

import java.util.Scanner;
import java.util.Stack;

/**
 * 有效的括号
 */
public class isValid {
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (ss[i] == '(') stack.push(')');
            else if (ss[i] == '[') stack.push(']');
            else if (ss[i] == '{') stack.push('}');
            else if (stack.isEmpty() || stack.peek() != ss[i]) return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }
}
