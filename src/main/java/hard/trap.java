package hard;

import java.util.Scanner;
import java.util.Stack;

/**
 * 接雨水
 */
public class trap {
    private static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) stack.push(i);
            else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        int w = i - stack.peek() - 1;
                        res += h * w;
                    }
                }
                stack.push(i);
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
        System.out.println(trap(height));
    }
}
