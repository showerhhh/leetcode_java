import java.util.ArrayList;
import java.util.List;

public class t54 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = matrix.length * matrix[0].length;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (count >= 1) {
            // 上循环（从左到右）
            for (int i = left; i <= right && count >= 1; i++) {
                list.add(matrix[top][i]);
                count--;
            }
            top++;
            // 右循环（从上到下）
            for (int i = top; i <= bottom && count >= 1; i++) {
                list.add(matrix[i][right]);
                count--;
            }
            right--;
            // 下循环（从右到左）
            for (int i = right; i >= left && count >= 1; i--) {
                list.add(matrix[bottom][i]);
                count--;
            }
            bottom--;
            // 左循环（从下到上）
            for (int i = bottom; i >= top && count >= 1; i--) {
                list.add(matrix[i][left]);
                count--;
            }
            left++;
        }
        return list;
    }
}