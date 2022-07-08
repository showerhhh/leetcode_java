public class t剑指_Offer_29 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1, left = 0, right = n - 1;
        int[] res = new int[m * n];
        int k = 0;
        int orient = 0;  // 0右1下2左3上
        while (up <= down && left <= right) {
            if (orient == 0) {
                for (int j = left; j <= right; j++) {
                    res[k++] = matrix[up][j];
                }
                up++;
            } else if (orient == 1) {
                for (int i = up; i <= down; i++) {
                    res[k++] = matrix[i][right];
                }
                right--;
            } else if (orient == 2) {
                for (int j = right; j >= left; j--) {
                    res[k++] = matrix[down][j];
                }
                down--;
            } else {
                for (int i = down; i >= up; i--) {
                    res[k++] = matrix[i][left];
                }
                left++;
            }
            orient = (orient + 1) % 4;
        }
        return res;
    }
}