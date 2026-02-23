package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 两数之和
 */
public class twoSum {
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                res[0] = map.get(tmp);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        String[] inputNums = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputNums[i]);
        }
        int target = sc.nextInt();
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
