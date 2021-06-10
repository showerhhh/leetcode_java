public class t剑指_Offer_47 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] value = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                value[i][j] = Math.max(value[i - 1][j], value[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return value[m][n];
    }
}