package mid;

import java.util.Scanner;

/**
 * 字符串解码
 */
public class decodeString {
    private static String decodeString(String s) {
        return decode(s.toCharArray());
    }

    private static int i = 0;

    private static String decode(char[] s) {
        StringBuilder res = new StringBuilder();
        int k = 0;
        while (i < s.length) {
            char c = s[i];
            i++;
            if (Character.isLetter(c)) res.append(c);
            else if (Character.isDigit(c)) k = k * 10 + c - '0';
            else if (c == '[') {
                String t = decode(s);
                res.repeat(t, k);
                k = 0;
            }
            else break;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(decodeString(s));
    }
}
