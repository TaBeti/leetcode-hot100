package mid;

import java.util.Scanner;

public class search {
    private static int search(int[] nums, int target) {
        int n = nums.length;
        int i = findMin(nums);
        if (target > nums[n - 1]) return binarySearch(nums, 0, i - 1, target);
        return binarySearch(nums, i, n - 1, target);
    }

    private static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int target = sc.nextInt();
        System.out.println(search(nums, target));
    }
}
