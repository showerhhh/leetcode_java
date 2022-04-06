import java.util.ArrayList;
import java.util.List;

public class t39 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t39 {
    ArrayList<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtracking(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    void backtracking(int[] candidates, int target, int idx, int sum, ArrayList<Integer> list) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtracking(candidates, target, i, sum + candidates[i], list);
            list.remove(list.size() - 1);
        }
    }

    void backtrack_2(int[] candidates, int target, int idx, int sum, ArrayList<Integer> list) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target || idx >= candidates.length) {
            return;
        }
        // 不选candidates[idx]
        backtrack_2(candidates, target, idx + 1, sum, list);
        // 选candidates[idx]
        list.add(candidates[idx]);
        backtrack_2(candidates, target, idx, sum + candidates[idx], list);
        list.remove(list.size() - 1);
    }
}