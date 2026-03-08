package mid;

import java.util.Scanner;

/**
 * 跳跃游戏
 */
public class canJump {
    private static boolean canJump(int[] nums) {
        int cover = 0;
        if (nums.length == 1) return true;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(canJump(nums));
    }
}
