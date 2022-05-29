public class t79 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t79 {
    boolean flag = false;
    int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtracking(board, word, 0, i, j, new boolean[m][n]);
                if (flag) {
                    return flag;
                }
            }
        }
        return flag;
    }

    void backtracking(char[][] board, String word, int k, int i, int j, boolean[][] visited) {
        if (k == word.length()) {
            flag = true;
            return;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(k)) {
            return;
        }
        visited[i][j] = true;
        for (int[] step : steps) {
            int newi = i + step[0];
            int newj = j + step[1];
            backtracking(board, word, k + 1, newi, newj, visited);
            if (flag) {
                break;
            }
        }
        visited[i][j] = false;
    }
}