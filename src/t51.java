import java.util.ArrayList;
import java.util.List;

public class t51 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t51 {
    ArrayList<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtracking(n, 0, board);
        return res;
    }

    void backtracking(int n, int curDepth, char[][] board) {
        if (curDepth >= n) {
            add(n, board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(n, board, curDepth, i)) {
                board[curDepth][i] = 'Q';
                backtracking(n, curDepth + 1, board);
                board[curDepth][i] = '.';
            }
        }
    }

    void add(int n, char[][] board) {
        // 将当前的board放入结果集res中
        ArrayList<String> t = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            t.add(String.valueOf(board[i]));
        }
        res.add(t);
    }

    boolean check(int n, char[][] board, int i, int j) {
        // 检查board[i][j]位置是否可以放皇后
        for (int k = 0; k <= i; k++) {
            if (board[k][j] == 'Q') {
                return false;
            }
        }
        for (int k = 0; k <= j; k++) {
            if (board[i][k] == 'Q') {
                return false;
            }
        }
        for (int k = 0; i - k >= 0 && j - k >= 0; k++) {
            if (board[i - k][j - k] == 'Q') {
                return false;
            }
        }
        for (int k = 0; i - k >= 0 && j + k < n; k++) {
            if (board[i - k][j + k] == 'Q') {
                return false;
            }
        }
        return true;
    }
}