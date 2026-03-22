package mid;

import java.util.Random;
import java.util.Scanner;

/**
 * 数组中的第 K个最大元素
 */
public class findKthLargest {
    private static int findKthLargest(int[] nums, int k) {
        int n = nums.length, targetIndex = n - k;
        int left = 0, right = n - 1;
        while (true) {
            int i = partition(nums, 0, n - 1);
            if (i == targetIndex) return nums[i];
            else if (i < targetIndex) left = i + 1;
            else right = i - 1;
        }
    }

    private static int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int i = left + random.nextInt(right - left + 1);
        int pivot = nums[i];
        swap(nums, i, left);

        i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && nums[i] < pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i >= j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, left, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int k = sc.nextInt();
        System.out.println(findKthLargest(nums, k));
    }
}
