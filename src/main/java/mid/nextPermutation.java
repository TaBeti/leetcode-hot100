package mid;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 下一个排列
 */
public class nextPermutation {
    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        //找第一个比右边相邻数小的数 x
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        //找比 x 大的最小的数 y
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;
            //找到就交换 x 和 y
            swap(nums, i, j);
        }
        //反转 y 右边部分的数组
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
