import java.util.ArrayList;
import java.util.List;

public class t面试题_0802 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0802 {
    boolean[][] visited;
    int r;
    int c;
    boolean flag;
    ArrayList<List<Integer>> res;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        flag = false;
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;
        visited = new boolean[r][c];
        res = new ArrayList<>();
        ArrayList<List<Integer>> path = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        t.add(0);
        t.add(0);
        path.add(t);
        backtrack(0, 0, path, obstacleGrid);
        return res;
    }

    void backtrack(int i, int j, ArrayList<List<Integer>> path, int[][] obstacleGrid) {
        if (i < 0 || i >= r || j < 0 || j >= c || visited[i][j] || obstacleGrid[i][j] == 1) {
            return;
        }
        if (flag) {
            return;
        }
        if (i == r - 1 && j == c - 1) {
            res = new ArrayList<>(path);
            flag = true;
            return;
        }

        visited[i][j] = true;

        ArrayList<Integer> t1 = new ArrayList<>();
        t1.add(i + 1);
        t1.add(j);
        path.add(t1);
        backtrack(i + 1, j, path, obstacleGrid);
        path.remove(path.size() - 1);

        ArrayList<Integer> t2 = new ArrayList<>();
        t2.add(i);
        t2.add(j + 1);
        path.add(t2);
        backtrack(i, j + 1, path, obstacleGrid);
        path.remove(path.size() - 1);
    }
}