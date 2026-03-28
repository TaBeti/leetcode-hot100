package hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * 滑动窗口最大值
 */
public class maxSlidingWindow {
    private static class MyQueue {
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
        MyQueue queue = new MyQueue();
        int idx = 0;
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
        String[] split = sc.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int k = sc.nextInt();
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
