import java.util.ArrayList;
import java.util.List;

public class t216 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t216 {
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1, 0, new ArrayList<>());
        return res;
    }

    void backtracking(int n, int k, int idx, int sum, ArrayList<Integer> list) {
        if (list.size() == k && sum == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() > k || sum > n) {
            return;
        }
        if (list.size() == k || sum == n) {
            return;
        }
        for (int i = idx; i <= 9; i++) {
            list.add(i);
            backtracking(n, k, i + 1, sum + i, list);
            list.remove(list.size() - 1);
        }
    }
}