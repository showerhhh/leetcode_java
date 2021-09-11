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
        backtrack(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }

    void backtrack(int idx, int sum, ArrayList<Integer> list, int[] candidates, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target || idx >= candidates.length) {
            return;
        }
        // 不选candidates[idx]
        backtrack(idx + 1, sum, list, candidates, target);
        // 选candidates[idx]
        list.add(candidates[idx]);
        backtrack(idx, sum + candidates[idx], list, candidates, target);
        list.remove(list.size() - 1);
    }
}