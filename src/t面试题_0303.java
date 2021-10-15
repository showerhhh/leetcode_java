import java.util.ArrayList;
import java.util.Stack;

public class t面试题_0303 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class StackOfPlates {
    ArrayList<Stack<Integer>> stack_list = new ArrayList<>();
    int cap;

    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if (cap <= 0) {
            return;
        }
        if (stack_list.isEmpty() || stack_list.get(stack_list.size() - 1).size() == cap) {
            Stack<Integer> new_stack = new Stack<>();
            stack_list.add(new_stack);
        }
        stack_list.get(stack_list.size() - 1).push(val);
    }

    public int pop() {
        if (stack_list.isEmpty()) {
            return -1;
        }
        int res = stack_list.get(stack_list.size() - 1).pop();
        if (stack_list.get(stack_list.size() - 1).isEmpty()) {
            stack_list.remove(stack_list.size() - 1);
        }
        return res;
    }

    public int popAt(int index) {
        if (stack_list.isEmpty() || index >= stack_list.size() || index < 0) {
            return -1;
        }
        int res = stack_list.get(index).pop();
        if (stack_list.get(index).isEmpty()) {
            stack_list.remove(index);
        }
        return res;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */