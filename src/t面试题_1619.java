import java.util.ArrayList;
import java.util.Collections;

public class t面试题_1619 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_1619 {
    int count;
    boolean[][] visited;
    int[][] orient = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int[] pondSizes(int[][] land) {
        int m = land.length, n = land[0].length;
        visited = new boolean[m][n];
        ArrayList<Integer> res_list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                dfs(i, j, land);
                if (count != 0) {
                    res_list.add(count);
                }
            }
        }
        Collections.sort(res_list);
        int[] res = new int[res_list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = res_list.get(i);
        }
        return res;
    }

    void dfs(int i, int j, int[][] land) {
        int m = land.length, n = land[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || land[i][j] != 0) {
            return;
        }
        count++;
        visited[i][j] = true;
        for (int k = 0; k < orient.length; k++) {
            int newi = i + orient[k][0];
            int newj = j + orient[k][1];
            dfs(newi, newj, land);
        }
    }
}