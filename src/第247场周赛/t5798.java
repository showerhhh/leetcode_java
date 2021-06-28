package 第247场周赛;

public class t5798 {
}

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int start_m = 0;
        int end_m = grid.length - 1;
        int start_n = 0;
        int end_n = grid[0].length - 1;
        while (start_m < end_m && start_n < end_n) {
            rotateGridOneLayer(grid, start_m, end_m, start_n, end_n, k);
            start_m++;
            end_m--;
            start_n++;
            end_n--;
        }
        return grid;
    }

    int[][] rotateGridOneLayer(int[][] grid, int start_m, int end_m, int start_n, int end_n, int k) {
        int m = end_m - start_m + 1;
        int n = end_n - start_n + 1;
        int count = m * 2 + n * 2 - 4;
        k %= count;
        for (int i = 0; i < k; i++) {
            rotateGridOneLayerOnce(grid, start_m, end_m, start_n, end_n);
        }
        return grid;
    }

    int[][] rotateGridOneLayerOnce(int[][] grid, int start_m, int end_m, int start_n, int end_n) {
        int pre = grid[start_m][start_n];
        int tmp;
        int i = start_m + 1;
        int j = start_n;
        for (; i <= end_m; i++) {
            tmp = grid[i][j];
            grid[i][j] = pre;
            pre = tmp;
        }

        i--;
        j++;
        for (; j <= end_n; j++) {
            tmp = grid[i][j];
            grid[i][j] = pre;
            pre = tmp;
        }

        j--;
        i--;
        for (; i >= start_m; i--) {
            tmp = grid[i][j];
            grid[i][j] = pre;
            pre = tmp;
        }

        i++;
        j--;
        for (; j >= start_n; j--) {
            tmp = grid[i][j];
            grid[i][j] = pre;
            pre = tmp;
        }

        return grid;
    }
}