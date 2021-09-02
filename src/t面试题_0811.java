public class t面试题_0811 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0811 {
    int count;

    public int waysToChange(int n) {
        int[] coins = new int[]{25, 10, 5, 1};
        count = 0;
        backtrack(0, 0, n, coins);
        return count;
    }

    void backtrack(int i, int sum, int n, int[] coins) {
        if (sum == n) {
            count++;
            return;
        }
        if (sum > n || i == coins.length) {
            return;
        }
        backtrack(i, sum + coins[i], n, coins);
        backtrack(i + 1, sum, n, coins);
    }
}