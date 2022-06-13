import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class t406 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t406 {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> res_list = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                } else {
                    if (o1[1] < o2[1]) {
                        return -1;
                    } else if (o1[1] > o2[1]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        for (int[] p : people) {
            res_list.add(p[1], p);
        }
        return res_list.toArray(new int[res_list.size()][]);
    }
}