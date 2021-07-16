public class t48 {
}

class Solution_t48 {
    public void rotate(int[][] matrix) {
        int tmp;
        int n = matrix.length;
        // 上下翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }
        // 主对角线翻转（转置）
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}