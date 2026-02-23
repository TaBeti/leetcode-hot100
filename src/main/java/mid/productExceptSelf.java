package mid;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 除自身以外数组的乘积
 */
public class productExceptSelf {
    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pre = new int[n], suf = new int[n];
        pre[0] = suf[n - 1] = 1;
        for (int i = 1; i < n; i++) pre[i] = pre[i - 1] * nums[i - 1];
        for (int i = n - 2; i >= 0; i--) suf[i] = suf[i + 1] * nums[i + 1];
        for (int i = 0; i < n; i++) res[i] = pre[i] * suf[i];
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
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
