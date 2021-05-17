import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class t207 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t207 {
    List<List<Integer>> adj;  // 邻接表，广度优先遍历和深度优先遍历都会用到
    int[] flag;  // 标记数组，深度优先遍历用到
    int[] degrees;  // 入度表，广度优先遍历用到

    public boolean canFinish_1(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int i) {
        if (flag[i] == 1) {
            return false;
        }
        if (flag[i] == -1) {
            return true;
        }
        flag[i] = 1;
        for (int neighbor : adj.get(i)) {
            if (!dfs(neighbor)) {
                return false;
            }
        }
        flag[i] = -1;
        return true;
    }

    public boolean canFinish_2(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        degrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            adj.get(cp[1]).add(cp[0]);
            degrees[cp[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int neighbor : adj.get(pre)) {
                degrees[neighbor]--;
                if (degrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return numCourses == 0;
    }
}