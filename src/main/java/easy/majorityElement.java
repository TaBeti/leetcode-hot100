package easy;

import java.util.Scanner;

/**
 * 多数元素4.7
 */
public class majorityElement {
    private static int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) count++;
            else if (--count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(majorityElement(nums));
    }
}
