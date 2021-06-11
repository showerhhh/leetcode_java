import java.util.HashSet;
import java.util.PriorityQueue;

public class t剑指_Offer_49 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_49 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        set.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long tmp = pq.poll();
            ugly = (int) tmp;
            for (int factor : factors) {
                long t = tmp * factor;
                if (!set.contains(t)) {
                    pq.offer(t);
                    set.add(t);
                }
            }
        }
        return ugly;
    }
}