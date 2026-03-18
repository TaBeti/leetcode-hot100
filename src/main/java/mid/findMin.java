package mid;

import java.util.Scanner;

/**
 * 寻找旋转排序数组中的最小值
 */
public class findMin {
    private static int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[n - 1]) left = mid + 1;
            else right = mid - 1;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(findMin(nums));
    }
}
