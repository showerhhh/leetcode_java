package 网易互娱雷火事业群笔试练习;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        t1 t = new t1();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] rect = new int[n][2];
            for (int i = 0; i < n; i++) {
                rect[i][0] = sc.nextInt();
                rect[i][1] = sc.nextInt();
            }
            t.sort(rect);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                builder.append(rect[i][0]);
                builder.append(' ');
                builder.append(rect[i][1]);
                builder.append(' ');
            }
            builder.deleteCharAt(builder.length() - 1);
            System.out.println(builder.toString());
        }
    }

    void sort(int[][] rect) {
        Arrays.sort(rect, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int f1 = o1[0] * o1[1] - o2[0] * o2[1];
                if (f1 != 0) {
                    return f1;
                } else {
                    int f2 = Math.min(o2[0], o2[1]) - Math.min(o1[0], o1[1]);
                    if (f2 != 0) {
                        return f2;
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            }
        });
    }
}
