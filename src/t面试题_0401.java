import java.util.ArrayList;

public class t面试题_0401 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0401 {
    boolean[] visited;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        ArrayList<Integer>[] adj = create_adj(n, graph);
        visited = new boolean[n];
        dfs(start, adj);
        return visited[target];
    }

    ArrayList<Integer>[] create_adj(int n, int[][] graph) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : graph) {
            int start = edge[0];
            int end = edge[1];
            if (!adj[start].contains(end)) {
                adj[start].add(end);
            }
        }
        return adj;
    }

    void dfs(int x, ArrayList<Integer>[] adj) {
        if (visited[x]) {
            return;
        }
        visited[x] = true;
        for (int y : adj[x]) {
            dfs(y, adj);
        }
    }
}