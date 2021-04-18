import java.util.ArrayList;

public class t155 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> min_stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayList<Integer>();
        min_stack = new ArrayList<Integer>();
        min_stack.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.add(val);
        int min = min_stack.get(min_stack.size() - 1);
        if (val < min) {
            min_stack.add(val);
        } else {
            min_stack.add(min);
        }
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        min_stack.remove(min_stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min_stack.get(min_stack.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */