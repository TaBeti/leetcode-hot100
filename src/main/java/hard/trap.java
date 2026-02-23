package hard;

import java.util.Scanner;
import java.util.Stack;

/**
 * 接雨水
 */
public class trap {
    private static int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[st.peek()]) st.push(i);
            else if (height[i] == height[st.peek()]) {
                st.pop();
                st.push(i);
            } else {
                while (!st.isEmpty() && height[i] > height[st.peek()]) {
                    int mid = st.pop();
                    if (!st.isEmpty()) {
                        int h = Math.min(height[st.peek()], i) - height[mid];
                        int w = i - st.peek() - 1;
                        res += h * w;
                    }
                }
                st.push(i);
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
        System.out.println(trap(height));
    }
}
