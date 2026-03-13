package mid;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 最长连续序列
 */
public class longestConsecutive {
    private static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0, seqLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                seqLen = 1;
                while (set.contains(++num)) seqLen++;
                res = Math.max(res, seqLen);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(longestConsecutive(nums));
    }
}
