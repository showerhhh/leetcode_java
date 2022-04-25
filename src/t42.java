public class t42 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] lMax = new int[n];  // 记录i左侧（包括i）的最大高度
        int[] rMax = new int[n];  // 记录i右侧（包括i）的最大高度
        int lmax = 0, rmax = 0;
        for (int i = 0; i < n; i++) {
            lmax = Math.max(lmax, height[i]);
            lMax[i] = lmax;
        }
        for (int i = n - 1; i >= 0; i--) {
            rmax = Math.max(rmax, height[i]);
            rMax[i] = rmax;
        }
        // 按列，计算每列的雨水。（第一列和最后一列无雨水）
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            int column = Math.min(lMax[i - 1], rMax[i + 1]) - height[i];
            if (column < 0) {
                column = 0;
            }
            sum += column;
        }
        return sum;
    }
}