public class t240 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int i = n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (target > matrix[i][j]) {
                j++;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}