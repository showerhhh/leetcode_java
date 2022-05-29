import java.util.Stack;

public class t85 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] row_heights = new int[m][n];
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == '1') {
                    count++;
                } else {
                    count = 0;
                }
                row_heights[i][j] = count;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int t = largestRectangleArea(row_heights[i]);
            maxArea = Math.max(maxArea, t);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] minLeftIndex = new int[n];  // 记录i左侧（不包括i）第一个小于该柱子的下标
        int[] minRightIndex = new int[n];  // 记录i右侧（不包括i）第一个小于该柱子的下标
        Stack<Integer> stack = new Stack<>();  // 单调栈，记录下标
        // 求i右侧（不包括i）第一个小于该柱子的下标
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int idx = stack.pop();
                minRightIndex[idx] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            minRightIndex[idx] = n;
        }
        // 求i左侧（不包括i）第一个小于该柱子的下标
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int idx = stack.pop();
                minLeftIndex[idx] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            minLeftIndex[idx] = -1;
        }
        // 求最大矩形面积
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = (minRightIndex[i] - minLeftIndex[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}