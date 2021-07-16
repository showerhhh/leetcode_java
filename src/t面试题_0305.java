import java.util.Stack;

public class t面试题_0305 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class SortedStack {
    Stack<Integer> stack;
    Stack<Integer> tmp;

    public SortedStack() {
        stack = new Stack<>();
        tmp = new Stack<>();
    }

    public void push(int val) {
        while (!stack.isEmpty() && stack.peek() < val) {
            tmp.push(stack.pop());
        }
        stack.push(val);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */