package mid;

import java.util.Scanner;

/**
 * 寻找重复数
 */
public class findDuplicate {
    private static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        int head = 0;
        while (slow != head) {
            slow = nums[slow];
            head = nums[head];
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(findDuplicate(nums));
    }
}
