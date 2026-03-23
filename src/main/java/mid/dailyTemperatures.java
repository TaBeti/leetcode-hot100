package mid;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 每日温度
 */
public class dailyTemperatures {
    private static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) stack.push(i);
            else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int[] temperatures = new int[split.length];
        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
