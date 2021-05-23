import java.util.ArrayList;
import java.util.List;

public class t417 {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        Solution_t417 solution = new Solution_t417();
        solution.pacificAtlantic(heights);
    }
}

class Solution_t417 {
    int n;  // 行数
    int m;  // 列数
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;
    boolean[][] flag1;  // 能否到太平洋
    boolean[][] flag2;  // 能否到大西洋
    boolean flag;  // 当前dfs从哪个洋出发，true为太平洋，false为大西洋

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        flag1 = new boolean[n][m];
        flag2 = new boolean[n][m];

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            flag = true;
            dfs(heights, i, 0);  // 左侧太平洋出发
        }
        visited = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            flag = true;
            dfs(heights, 0, i);  // 上侧太平洋出发
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            flag = false;
            dfs(heights, i, m - 1);  // 右侧大西洋出发
        }
        visited = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            flag = false;
            dfs(heights, n - 1, i);  // 下侧大西洋出发
        }

        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (flag1[i][j] && flag2[i][j]) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    result.add(tmp);
                }
            }
        }
        return result;
    }

    void dfs(int[][] heights, int i, int j) {
        if (visited[i][j]) {
            return;
        }

        if (flag) {
            flag1[i][j] = true;
        } else {
            flag2[i][j] = true;
        }
        visited[i][j] = true;

        for (int[] dir : directions) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 && newi < n && newj >= 0 && newj < m && heights[newi][newj] >= heights[i][j]) {
                dfs(heights, newi, newj);
            }
        }
    }
}