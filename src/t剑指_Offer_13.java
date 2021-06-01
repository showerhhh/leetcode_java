public class t剑指_Offer_13 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t剑指_Offer_13 {
    boolean[][] visited;
    int count;
    int m;
    int n;
    int k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        count = 0;
        dfs(0, 0);
        return count;
    }

    void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (visited[i][j] || sum(i, j) > k) {
            return;
        }
        visited[i][j] = true;
        count++;

        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

    int sum(int i, int j) {
        int tmp = 0;
        while (i != 0) {
            tmp += i % 10;
            i /= 10;
        }
        while (j != 0) {
            tmp += j % 10;
            j /= 10;
        }
        return tmp;
    }
}