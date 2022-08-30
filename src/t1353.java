import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class t1353 {
}

class Solution_t1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];  // 堆中保存了当前已经开始的会议，按结束时间排序
            }
        });
        int curTime = events[0][0];
        int count = 0;
        int i = 0;
        while (i < events.length || !queue.isEmpty()) {
            // 如果今天会议开始，则将其加入堆中
            while (i < events.length && events[i][0] == curTime) {
                queue.offer(events[i]);
                i++;
            }
            // 如果堆顶会议已经结束，则丢弃
            while (!queue.isEmpty() && queue.peek()[1] < curTime) {
                queue.poll();
            }
            // 选取堆顶会议，作为今天的打卡会议
            if (!queue.isEmpty()) {
                queue.poll();
                count++;
                curTime++;
            } else {
                // 如果堆为空，则今天没有会议可打卡
                curTime++;
            }
        }
        return count;
    }
}