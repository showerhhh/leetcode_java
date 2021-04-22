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
        ArrayList<Integer> stack = new ArrayList<Integer>();
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
}