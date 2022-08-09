package 趋势科技笔试;

import java.util.ArrayList;

public class t1 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0}
        };
        t1 t = new t1();
        t.f(grid);
        System.out.println("test");
    }

    int m;
    int n;
    boolean[][] visited;

    int[] f(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    ArrayList<int[]> point = new ArrayList<>();
                    dfs(grid, i, j, point);
                    maxLen = Math.max(maxLen, maxLength(point));
                }
            }
        }
        return new int[]{count, maxLen};
    }

    void dfs(int[][] grid, int i, int j, ArrayList<int[]> point) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        point.add(new int[]{i, j});
        visited[i][j] = true;
        dfs(grid, i + 1, j, point);
        dfs(grid, i - 1, j, point);
        dfs(grid, i, j + 1, point);
        dfs(grid, i, j - 1, point);
    }

    int maxLength(ArrayList<int[]> point) {
        int res = 0;
        for (int[] x : point) {
            for (int[] y : point) {
                int len = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
