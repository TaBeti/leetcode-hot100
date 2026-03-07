package mid;

import java.util.Stack;

/**
 * 最小栈
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min_stack.isEmpty() || val <= min_stack.peek()) min_stack.push(val);
    }

    public void pop() {
        if (stack.pop().equals(min_stack.peek())) min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());//-3
        minStack.pop();
        System.out.println(minStack.top());//0
        System.out.println(minStack.getMin());//-2
    }
}
