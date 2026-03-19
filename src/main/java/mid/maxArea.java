package mid;

import java.util.Scanner;

/**
 * 盛最多水的容器
 */
public class maxArea {
    private static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i) * height[i]);
                i++;
            } else {
                res = Math.max(res, (j - i) * height[j]);
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] height = new int[split.length];
        for (int i = 0; i < height.length; i++) {
            height[i] = Integer.parseInt(split[i]);
        }
        System.out.println(maxArea(height));
    }
}
