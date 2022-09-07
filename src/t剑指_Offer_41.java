import java.util.Comparator;
import java.util.PriorityQueue;

public class t剑指_Offer_41 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.findMedian();
    }

}

class MedianFinder {
    PriorityQueue<Integer> heap1;
    PriorityQueue<Integer> heap2;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        heap1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        heap2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num) {
        if (heap1.isEmpty()) {
            heap1.offer(num);
            return;
        }
        if (num > heap1.peek()) {
            heap2.offer(num);
            while (heap1.size() < heap2.size()) {
                heap1.offer(heap2.poll());
            }
        } else {
            heap1.offer(num);
            while (heap1.size() > heap2.size() + 1) {
                heap2.offer(heap1.poll());
            }
        }
    }

    public double findMedian() {
        if (heap1.size() == heap2.size()) {
            return (heap1.peek() + heap2.peek()) / 2.0;
        } else {
            return heap1.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */