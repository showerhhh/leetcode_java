public class t11 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int maxA = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            maxA = Math.max(maxA, Math.min(height[i], height[j]) * (j - i));
        }
        return maxA;
    }
}