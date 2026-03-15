package hard;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 */
public class MedianFinder {
    //左边数组找最大值，构建大根堆
    private final PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    //右边数组找最小值，构建小根堆
    private final PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {}

    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) return left.peek();
        return (left.peek() + right.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());//1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());//2.0
    }
}
