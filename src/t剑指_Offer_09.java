import java.util.Stack;

public class t剑指_Offer_09 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s1.isEmpty()) {
            return -1;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int res = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return res;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */