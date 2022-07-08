package 第299场周赛;

public class t2319 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check(grid, n, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean check(int[][] grid, int n, int i, int j) {
        if (i == j || i == n - 1 - j) {
            if (grid[i][j] != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (grid[i][j] == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}