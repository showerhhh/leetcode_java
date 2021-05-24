public class t剑指_Offer_12 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        Solution_t剑指_Offer_12 solution = new Solution_t剑指_Offer_12();
        solution.exist(board, word);
    }
}

class Solution_t剑指_Offer_12 {
    int n;
    int m;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;
    boolean flag;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                flag = false;
                dfs(board, i, j, word);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    void dfs(char[][] board, int i, int j, String word) {
        if (word.equals("")) {
            flag = true;
            return;
        }
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || board[i][j] != word.charAt(0)) {
            return;
        }

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            dfs(board, newi, newj, word.substring(1));
            if(flag){
                break;  // 已经找到，则提前结束
            }
        }
        visited[i][j] = false;
    }
}