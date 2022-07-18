import java.util.LinkedList;
import java.util.Queue;

public class t剑指_Offer_59_II {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class MaxQueue {
    Queue<Integer> queue;
    LinkedList<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return max.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!max.isEmpty() && value > max.peekLast()) {
            max.pollLast();
        }
        max.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int res = queue.poll();
        if (res == max.peekFirst()) {
            max.pollFirst();
        }
        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */