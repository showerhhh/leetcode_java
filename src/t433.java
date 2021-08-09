import java.util.HashMap;
import java.util.HashSet;

public class t433 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t433 {
    String end;
    HashMap<String, Boolean> visited = new HashMap<>();
    HashMap<String, HashSet<String>> adj = new HashMap<>();
    int minStep = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        this.end = end;
        // 访问标记初始化
        for (String t : bank) {
            visited.put(t, false);
        }
        // 邻接矩阵初始化
        adj.put(start, new HashSet<>());
        for (String t : bank) {
            adj.put(t, new HashSet<>());
        }
        // 构建邻接矩阵
        // 1、不存在自环，由linjie函数所决定
        // 2、start与bank中的节点连接，start仅有出度没有入度
        // 3、bank中的节点相互连接，两个节点会相互连接
        for (String s : bank) {
            if (linjie(start, s)) {
                adj.get(start).add(s);
            }
        }
        for (String s1 : bank) {
            for (String s2 : bank) {
                if (linjie(s1, s2)) {
                    adj.get(s1).add(s2);
                }
            }
        }
        backtracking(start, 0);
        if (minStep == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minStep;
        }
    }

    boolean linjie(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    void backtracking(String s, int step) {
        if (s.equals(end)) {
            if (step < minStep) {
                minStep = step;
            }
            return;
        }
        for (String next : adj.get(s)) {
            if (!visited.get(next)) {
                visited.put(next, true);
                backtracking(next, step + 1);
                visited.put(next, false);
            }
        }
    }
}