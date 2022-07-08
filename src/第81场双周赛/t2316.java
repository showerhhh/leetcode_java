package 第81场双周赛;

import java.util.ArrayList;
import java.util.HashMap;

public class t2316 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t2316 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public long countPairs(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            add(i);
        }
        for (int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
        HashMap<Integer, Long> nodeCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            nodeCount.put(root, nodeCount.getOrDefault(root, 0L) + 1);
        }
        ArrayList<Long> list = new ArrayList<>(nodeCount.values());
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i) * (n - list.get(i));
        }
        return res / 2;
    }

    void add(int x) {
        if (!map.containsKey(x)) {
            map.put(x, -1);
        }
    }

    boolean isConnected(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        return rootX == rootY;
    }

    void connect(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            map.put(rootX, rootY);
        }
    }

    int find(int x) {
        int root = x;
        while (map.get(root) != -1) {
            root = map.get(root);
        }
        // 路径压缩
        while (x != root) {
            int tmp = map.get(x);
            map.put(x, root);
            x = tmp;
        }
        return root;
    }
}

class Solution_t2316_v2 {
    ArrayList<Integer>[] adj;  // 邻接表
    boolean[] visited;
    long nodeCount;

    public long countPairs(int n, int[][] edges) {
        makeGraph(n, edges);
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                nodeCount = 0;
                dfs(i);
                list.add(nodeCount);
            }
        }
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i) * (n - list.get(i));
        }
        return res / 2;
    }

    void makeGraph(int n, int[][] edges) {
        visited = new boolean[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            adj[i].add(j);
            adj[j].add(i);
        }
    }

    void dfs(int i) {
        if (visited[i]) {
            return;
        }
        nodeCount++;
        visited[i] = true;
        for (int node : adj[i]) {
            dfs(node);
        }
    }
}