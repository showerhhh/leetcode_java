package 第304场周赛;

import java.util.ArrayList;
import java.util.HashSet;

public class t2359 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t2359 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] d1 = new int[n];
        for (int i = 0; i < n; i++) {
            d1[i] = Integer.MAX_VALUE;
        }
        HashSet<Integer> set1 = new HashSet<>();
        int distance1 = 0;
        int p = node1;
        while (p != -1 && !set1.contains(p)) {
            d1[p] = distance1;
            distance1++;
            set1.add(p);
            p = edges[p];
        }

        int[] d2 = new int[n];
        for (int i = 0; i < n; i++) {
            d2[i] = Integer.MAX_VALUE;
        }
        HashSet<Integer> set2 = new HashSet<>();
        int distance2 = 0;
        int q = node2;
        while (q != -1 && !set2.contains(q)) {
            d2[q] = distance2;
            distance2++;
            set2.add(q);
            q = edges[q];
        }

        int res = -1, minDist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int dist = Math.max(d1[i], d2[i]);
            if (dist < minDist) {
                res = i;
                minDist = dist;
            }
        }
        return res;
    }
}