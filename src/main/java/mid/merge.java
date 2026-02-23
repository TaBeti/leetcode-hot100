package mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 合并区间
 */
public class merge {
    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        LinkedList<int[]> res = new LinkedList<>();
        int left = intervals[0][0], right = intervals[0][1];
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (res.getLast()[1] >= intervals[i][0]) {
                left = res.getLast()[0];
                right = Math.max(res.getLast()[1], intervals[i][1]);
                res.removeLast();
                res.add(new int[]{left, right});
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = sc.nextInt();
            }
        }
        for (int[] interval : merge(intervals)) {
            System.out.print(Arrays.toString(interval) + " ");
        }
    }
}
