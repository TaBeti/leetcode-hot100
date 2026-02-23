package mid;

import java.util.Scanner;

/**
 * 盛最多水的容器
 */
public class maxArea {
    private static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
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
        int n = sc.nextInt();
        sc.nextLine();
        int[] height = new int[n];
        String[] inputHeight = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(inputHeight[i]);
        }
        System.out.println(maxArea(height));
    }
}
