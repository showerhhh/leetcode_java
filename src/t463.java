public class t463 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t463 {
    int n, m;
    int count;

    public int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            count++;
            return;
        }
        if (grid[i][j] == 2) {
            return;
        }
        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}