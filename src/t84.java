import java.util.ArrayList;

public class t84 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution_t84 solution = new Solution_t84();
        System.out.println(solution.largestRectangleArea(heights));
    }
}

class Solution_t84 {
    public int largestRectangleArea(int[] heights) {
        ArrayList<Integer> stack = new ArrayList<>();
        int max = 0;

        //左右两边各加一个0
        int[] new_heights = new int[heights.length + 2];
        for (int i = 0; i < new_heights.length; i++) {
            if (i == 0 || i == new_heights.length - 1) {
                new_heights[i] = 0;
            } else {
                new_heights[i] = heights[i - 1];
            }
        }

        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[i] < new_heights[stack.get(stack.size() - 1)]) {
                int cur = stack.remove(stack.size() - 1);  // 以cur指向的数字为高度
                int left = stack.get(stack.size() - 1);  // left指向左边第一个小于new_heights[cur]的位置
                int right = i;  // right指向右边第一个小于new_heights[cur]的位置
                max = Math.max(max, (right - left - 1) * new_heights[cur]);
            }
            stack.add(i);
        }
        return max;
    }

    public int largestRectangleArea_2(int[] heights) {
        int n = heights.length;
        int[] minLeftIndex = new int[n];  // 记录i左侧（不包括i）第一个小于该柱子的下标
        int[] minRightIndex = new int[n];  // 记录i右侧（不包括i）第一个小于该柱子的下标
        for (int i = 0; i < n; i++) {
            // 求i左侧（不包括i）第一个小于该柱子的下标
            int lidx = i - 1;
            while (lidx >= 0 && heights[lidx] >= heights[i]) {
                lidx--;
            }
            minLeftIndex[i] = lidx;
            // 求i右侧（不包括i）第一个小于该柱子的下标
            int ridx = i + 1;
            while (ridx < n && heights[ridx] >= heights[i]) {
                ridx++;
            }
            minRightIndex[i] = ridx;
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = (minRightIndex[i] - minLeftIndex[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}