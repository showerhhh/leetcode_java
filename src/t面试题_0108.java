import java.util.HashSet;

public class t面试题_0108 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0108 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sign = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    changeMatrix(matrix, m, n, i, j, sign);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == sign) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    void changeMatrix(int[][] matrix, int m, int n, int i, int j, int sign) {
        // 将i行和j列的非零数字改变成-1
        // i行
        for (int k = 0; k < n; k++) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = sign;
            }
        }
        // j列
        for (int k = 0; k < m; k++) {
            if (matrix[k][j] != 0) {
                matrix[k][j] = sign;
            }
        }
    }

    public void setZeroes_2(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int sign = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row.contains(i) || column.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}