import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class t1738 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pre = new int[n + 1][m + 1];
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            pre[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            pre[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                tmp.add(pre[i][j]);
            }
        }

        Collections.sort(tmp, new Comp());
        return tmp.get(k - 1);
    }

    class Comp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                // o1排前面
                return -1;
            } else if (o1 < o2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}