package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 组合总和
 */
public class combinationSum {
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private static void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum > target) break;
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] candidates = new int[split.length];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = Integer.parseInt(split[i]);
        }
        int target = sc.nextInt();
        System.out.println(combinationSum(candidates, target));
    }
}
