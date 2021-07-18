package 第250场周赛;

public class t5815 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t5815 {
    int m;
    int n;
    boolean[][] flag;
    int[][] points;
    int maxValue;

    public long maxPoints(int[][] points) {
        // 超时
        m = points.length;
        n = points[0].length;
        flag = new boolean[m][n];
        this.points = points;
        maxValue = 0;
        backtracking(0, 0);
        return maxValue;
    }

    void backtracking(int row, int curValue) {
        if (row == m) {
            if (curValue > maxValue) {
                maxValue = curValue;
            }
            return;
        }
        for (int column = 0; column < n; column++) {
            flag[row][column] = true;
            backtracking(row + 1, curValue + addValue(row, column));
            flag[row][column] = false;
        }
    }

    int addValue(int row, int column) {
        if (row == 0) {
            return points[row][column];
        } else {
            int preColumn;
            for (preColumn = 0; preColumn < n; preColumn++) {
                if (flag[row - 1][preColumn]) {
                    break;
                }
            }
            return points[row][column] - Math.abs(column - preColumn);
        }
    }
}