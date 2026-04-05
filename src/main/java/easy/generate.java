package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 杨辉三角4.5
 */
public class generate {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            row.add(1);
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(generate(n));
    }
}
