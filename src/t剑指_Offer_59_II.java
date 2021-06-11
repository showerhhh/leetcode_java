import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class t剑指_Offer_59_II {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class MaxQueue {
    Queue<Integer> queue;

    public MaxQueue() {
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return Collections.max(queue);
    }

    public void push_back(int value) {
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */