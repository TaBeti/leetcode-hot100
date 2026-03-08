package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 划分字母区间
 */
public class partitionLabels {
    private static List<Integer> partitionLabels(String s) {
        int[] hash = new int[26];
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) hash[ss[i] - 'a'] = i;
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        for (int i = 0; i < ss.length; i++) {
            right = Math.max(right, hash[ss[i] - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(partitionLabels(s));
    }
}
