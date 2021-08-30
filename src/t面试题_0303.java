import java.util.ArrayList;
import java.util.Stack;

public class t面试题_0303 {
    public static void main(String[] args) {
        System.out.println("未通过！");
    }
}

class StackOfPlates {
    ArrayList<Stack<Integer>> listOfStack = new ArrayList<>();
    int cap;

    public StackOfPlates(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if (cap <= 0) {
            return;
        }
        for (int i = 0; i < listOfStack.size(); i++) {
            Stack<Integer> s = listOfStack.get(i);
            if (s.size() < cap) {
                s.push(val);
                return;
            }
        }
        Stack<Integer> s = new Stack<>();
        s.push(val);
        listOfStack.add(s);
    }

    public int pop() {
        for (int i = listOfStack.size() - 1; i >= 0; i--) {
            Stack<Integer> s = listOfStack.get(i);
            if (!s.isEmpty()) {
                return s.pop();
            } else {
                listOfStack.remove(i);
            }
        }
        return -1;
    }

    public int popAt(int index) {
        while (index < listOfStack.size()) {
            Stack<Integer> s = listOfStack.get(index);
            if (!s.isEmpty()) {
                return s.pop();
            } else {
                listOfStack.remove(index);
            }
        }
        return -1;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */