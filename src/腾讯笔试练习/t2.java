package 腾讯笔试练习;

public class t2 {
    public static void main(String[] args) {
        Solution_t2 solution = new Solution_t2();
        int[] heights = new int[]{5, 3, 8, 3, 2, 5};
        solution.findBuilding(heights);
    }
}

class Solution_t2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param heights int整型一维数组
     * @return int整型一维数组
     */
    public int[] findBuilding(int[] heights) {
        // write code here
        int n = heights.length;
        int[] dp_left = new int[n];  // 以i结尾的最长递减子序列的长度
        dp_left[0] = 1;
        for (int i = 1; i < n; i++) {
            int maxLength = 1;
            for (int j = 0; j < i; j++) {
                if (heights[j] > heights[i]) {
                    maxLength = Math.max(maxLength, dp_left[j] + 1);
                }
            }
            dp_left[i] = maxLength;
        }
        int[] dp_right = new int[n];  // 以i开头的最长增子序列的长度
        dp_right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int maxLength = 1;
            for (int j = n - 1; j > i; j--) {
                if (heights[j] > heights[i]) {
                    maxLength = Math.max(maxLength, dp_right[j] + 1);
                }
            }
            dp_right[i] = maxLength;
        }
        int[] res = new int[n];
        res[0] = dp_right[1] + 1;
        res[n - 1] = dp_left[n - 2] + 1;
        for (int i = 1; i < n - 1; i++) {
            res[i] = dp_left[i - 1] + dp_right[i + 1] - 1;
        }
        return res;
    }
}