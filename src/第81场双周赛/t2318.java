package 第81场双周赛;

import java.util.ArrayList;
import java.util.HashMap;

public class t2318 {
    public static void main(String[] args) {
        Solution_t2318 solution = new Solution_t2318();
        System.out.println(solution.distinctSequences(4));
    }
}

class Solution_t2318 {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    int res = 0;

    public int distinctSequences(int n) {
        if (n == 1) {
            return 6;
        }
        makeMap();
        for (String cur : map.keySet()) {
            backtracking(n, cur, 2);
        }
        return res;
    }

    void backtracking(int n, String cur, int idx) {
        if (idx == n) {
            res++;
            return;
        }
        for (int digit : map.get(cur)) {
            backtracking(n, cur.substring(1) + String.valueOf(digit), idx + 1);
        }
    }

    void makeMap() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (j == i || gcd_v1(i, j) != 1) {
                    continue;
                }
                for (int k = 1; k <= 6; k++) {
                    if (k == i || k == j || gcd_v1(j, k) != 1) {
                        continue;
                    }
                    String key = String.valueOf(i) + String.valueOf(j);
                    ArrayList<Integer> list = map.getOrDefault(key, new ArrayList<>());
                    list.add(k);
                    map.put(key, list);
                }
            }
        }
    }

    int gcd_v1(int a, int b) {
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }

    int gcd_v2(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcd_v2(a - b, b);
        } else {
            return gcd_v2(b - a, a);
        }
    }
}
