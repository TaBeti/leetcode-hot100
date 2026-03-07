package hard;

import java.util.Scanner;
import java.util.Stack;

/**
 * 柱状图中的最大矩形
 */
public class largestRectangleArea {
    private static int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        newHeights[0] = 0;
        newHeights[heights.length + 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < newHeights.length; i++) {
            if (newHeights[i] > newHeights[stack.peek()]) stack.push(i);
            else if (newHeights[i] > newHeights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek(), right = i;
                        int w = right - left - 1, h = newHeights[mid];
                        res = Math.max(res, w * h);
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
        int[] heights = new int[split.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(split[i]);
        }
        System.out.println(largestRectangleArea(heights));
    }
}
