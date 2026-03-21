package mid;

import java.util.Scanner;

/**
 * 乘积最大子数组
 */
public class maxProduct {
    private static int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] maxDp = new int[nums.length], minDp = new int[nums.length];
        maxDp[0] = minDp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(nums[i], Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(nums[i], Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            res = Math.max(res, maxDp[i]);
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
        System.out.println(maxProduct(nums));
    }
}
