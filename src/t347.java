import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class t347 {
}

class Solution_t347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.count > o2.count) {
                    return -1;
                } else if (o1.count < o2.count) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().val;
        }
        return res;
    }

    class Node {
        int val;
        int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}