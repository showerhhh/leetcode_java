public class t59 {
    public static void main(String[] args) {
        Solution_t59 solution = new Solution_t59();
        solution.generateMatrix(3);
    }
}

class Solution_t59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;  // 计数，赋给每个格子
        int i = 0, j = 0;  // 当前位置坐标
        int length = n - 1;  // 每一圈的四个循环的长度
        int loop = n / 2;  // 总共有几圈
        while (loop > 0) {
            // 上循环（从左到右）
            for (int k = 0; k < length; k++) {
                res[i][j++] = count++;
            }
            // 右循环（从上到下）
            for (int k = 0; k < length; k++) {
                res[i++][j] = count++;
            }
            // 下循环（从右到左）
            for (int k = 0; k < length; k++) {
                res[i][j--] = count++;
            }
            // 左循环（从下到上）
            for (int k = 0; k < length; k++) {
                res[i--][j] = count++;
            }

            i++;
            j++;
            length -= 2;
            loop--;
        }

        if (n % 2 == 1) {
            // n为奇数时，中心元素需要单独处理
            int mid = n / 2;
            res[mid][mid] = n * n;
        }
        return res;
    }
}