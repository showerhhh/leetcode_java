import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class t239 {
    public static void main(String[] args) {
        Solution_t239 solution = new Solution_t239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution_t239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<Pair<Integer, Integer>>(new MyComparator());
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.offer(new Pair<>(nums[i], i));
        }
        result[0] = queue.peek().getKey();

        for (int i = k; i < nums.length; i++) {
            queue.offer(new Pair<>(nums[i], i));
            while (queue.peek().getValue() < i - k + 1) {
                queue.poll();
            }
            result[i - k + 1] = queue.peek().getKey();
        }
        return result;
    }

    class MyComparator implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            if (o1.getKey() > o2.getKey()) {
                return -1;  //o1在前
            } else if (o1.getKey().equals(o2.getKey())) {
                return 0;
            } else {
                return 1;  //o1在后
            }
        }
    }
}