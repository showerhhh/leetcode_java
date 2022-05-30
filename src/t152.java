public class t152 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t152 {
    public int maxProduct(int[] nums) {
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        int maxPro = dp_max[0];
        for (int i = 1; i < nums.length; i++) {
            dp_max[i] = threeMax(dp_max[i - 1] * nums[i], dp_min[i - 1] * nums[i], nums[i]);
            dp_min[i] = threeMin(dp_min[i - 1] * nums[i], dp_max[i - 1] * nums[i], nums[i]);
            maxPro = Math.max(maxPro, dp_max[i]);
        }
        return maxPro;
    }

    int threeMax(int a, int b, int c) {
        int t = Math.max(a, b);
        return Math.max(t, c);
    }

    int threeMin(int a, int b, int c) {
        int t = Math.min(a, b);
        return Math.min(t, c);
    }
}