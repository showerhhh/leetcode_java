import java.util.Stack;

public class t232 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class MyQueue {
    Stack<Integer> stack1;  // 主栈
    Stack<Integer> stack2;  // 辅栈

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!stack1.isEmpty()) {
            int e = stack1.pop();
            stack2.push(e);
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            int e = stack2.pop();
            stack1.push(e);
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */