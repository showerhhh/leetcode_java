import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class t56 {
    public static void main(String[] args) {
        Solution_t56 solution = new Solution_t56();
        int[][] t = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        solution.merge(t);
    }
}

class Solution_t56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        ArrayList<int[]> res_list = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int start = intervals[i][0];
            int j = i;
            int end = intervals[j][1];
            while (j + 1 < n && end >= intervals[j + 1][0]) {
                end = Math.max(end, intervals[j + 1][1]);
                j++;
            }
            res_list.add(new int[]{start, end});
            i = j + 1;
        }
        int[][] a = new int[res_list.size()][2];
        for (int m = 0; m < a.length; m++) {
            a[m][0] = res_list.get(m)[0];
            a[m][1] = res_list.get(m)[1];
        }
        return a;
    }
}