package mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 和为 K 的子数组
 */
public class subarraySum {
    private static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) res += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        String[] inputNums = sc.nextLine().split(" ");
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputNums[i]);
        }
        System.out.println(subarraySum(nums, k));
    }
}
