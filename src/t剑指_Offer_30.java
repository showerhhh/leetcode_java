import java.util.Stack;

public class t剑指_Offer_30 {
    public static void main(String[] args) {
        System.out.println("test");
    }

    class MinStack {
        Stack<Integer> nums_stack;
        Stack<Integer> min_stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            nums_stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int x) {
            nums_stack.push(x);
            if (min_stack.isEmpty()) {
                min_stack.push(x);
            } else {
                min_stack.push(Math.min(min_stack.peek(), x));
            }
        }

        public void pop() {
            nums_stack.pop();
            min_stack.pop();
        }

        public int top() {
            return nums_stack.peek();
        }

        public int min() {
            return min_stack.peek();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */