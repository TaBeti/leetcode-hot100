package mid;

import java.util.Scanner;

/**
 * 跳跃游戏II
 */
public class jump {
    private static int jump(int[] nums) {
        int cover = 0, nextCover = 0;
        if (nums.length == 1) return 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextCover = Math.max(nextCover, i + nums[i]);
            if (i == cover) {
                cover = nextCover;
                res++;
            }
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
        System.out.println(jump(nums));
    }
}
