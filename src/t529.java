public class t529 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t529 {
    int m;
    int n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        } else {
            dfs(board, x, y);
            return board;
        }
    }

    void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') {
            return;
        }
        int count = countM(board, x, y);
        if (count != 0) {
            board[x][y] = (char) (count + '0');
            return;
        }

        board[x][y] = 'B';
        for (int[] dir : directions) {
            dfs(board, x + dir[0], y + dir[1]);
        }
    }

    int countM(char[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && board[new_i][new_j] == 'M') {
                count++;
            }
        }
        return count;
    }
}