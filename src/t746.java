public class t746 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp_i_2 = 0, dp_i_1 = 0;
        int dp_i = 0;
        for (int i = 2; i <= n; i++) {
            dp_i = Math.min(dp_i_2 + cost[i - 2], dp_i_1 + cost[i - 1]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}