import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class t210 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t210 {
    List<List<Integer>> adj;  // 邻接表
    int[] degrees;  // 入度表

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        degrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            adj.get(cp[1]).add(cp[0]);
            degrees[cp[0]]++;
        }

        ArrayList<Integer> tmp = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            tmp.add(pre);
            for (int neighbor : adj.get(pre)) {
                degrees[neighbor]--;
                if (degrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (tmp.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < tmp.size(); i++) {
                result[i] = tmp.get(i);
            }
            return result;
        } else {
            return new int[0];
        }
    }
}