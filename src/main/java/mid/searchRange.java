package mid;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在排序数组中查找元素的第一和最后一个位置
 */
public class searchRange {
    private static int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        int end = binarySearch(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int target = sc.nextInt();
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
