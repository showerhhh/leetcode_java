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

    public void setZeroes_3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 标记第一行和第一列的情况
        boolean flagRow0 = false, flagColumn0 = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagColumn0 = true;
                break;
            }
        }

        // 标记其他行和列的情况
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 重置其他行和列
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 重置第一行和第一列
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (flagColumn0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}