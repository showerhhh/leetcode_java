import java.util.ArrayList;
import java.util.HashSet;

public class t37 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t37 {
    HashSet<Integer>[] row = new HashSet[9];
    HashSet<Integer>[] column = new HashSet[9];
    HashSet<Integer>[][] block = new HashSet[3][3];
    ArrayList<int[]> step = new ArrayList<>();
    boolean complete = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                block[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {  // 非数字的位置存入一个列表中，列表表示回溯时要进行的所有步骤
                    step.add(new int[]{i, j});
                } else {  // 数字存入集合中
                    int t = Integer.parseInt(String.valueOf(board[i][j]));
                    row[i].add(t);
                    column[j].add(t);
                    block[i / 3][j / 3].add(t);
                }
            }
        }
        backtracking(0, board);
    }

    void backtracking(int idx, char[][] board) {
        if (idx == step.size()) {  // 复制board给board_res
            complete = true;
            return;
        }
        int i = step.get(idx)[0];
        int j = step.get(idx)[1];
        for (int k = 1; k <= 9; k++) {
            if (!complete && !row[i].contains(k) && !column[j].contains(k) && !block[i / 3][j / 3].contains(k)) {
                row[i].add(k);
                column[j].add(k);
                block[i / 3][j / 3].add(k);
                board[i][j] = (char) ('0' + k);
                backtracking(idx + 1, board);
                // 不能有board[i][j] = '.';
                block[i / 3][j / 3].remove(k);
                column[j].remove(k);
                row[i].remove(k);
            }
        }
    }
}