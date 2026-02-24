package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * 滑动窗口最大值
 */
public class maxSlidingWindow {
    public static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) deque.poll();
        }

        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) deque.removeLast();
            deque.add(val);
        }

        int peek() {
            return deque.peek();
        }
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int idx = 0;
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) queue.add(nums[i]);
        res[idx++] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            res[idx++] = queue.peek();
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
        int k = sc.nextInt();
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
