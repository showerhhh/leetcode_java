import java.util.HashSet;

public class t526 {
    public static void main(String[] args) {
        Solution_t526 solution = new Solution_t526();
        solution.countArrangement(2);
    }
}

class Solution_t526 {
    boolean[] visited;
    int count;
    HashSet<Integer>[] match;

    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        count = 0;
        match = new HashSet[n];
        for (int i = 0; i < n; i++) {
            match[i] = new HashSet<>();
            int idx = i + 1;
            for (int digit = 1; digit <= n; digit++) {
                if (digit % idx == 0 || idx % digit == 0) {
                    match[i].add(digit);
                }
            }
        }
        backtracking(1, n);
        return count;
    }

    void backtracking(int idx, int n) {
        if (idx == n + 1) {
            count++;
            return;
        }
        for (int digit = 1; digit <= n; digit++) {
            if (!visited[digit] && match[idx - 1].contains(digit)) {
                visited[digit] = true;
                backtracking(idx + 1, n);
                visited[digit] = false;
            }
        }
    }
}