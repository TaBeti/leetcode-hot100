package mid;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 颜色分类
 */
public class sortColors {
    private static void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            nums[i] = 2;
            if (x <= 1) nums[p1++] = 1;
            if (x == 0) nums[p0++] = 0;
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
