import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t40 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t40 {
    ArrayList<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }

    void backtrack(int idx, int sum, ArrayList<Integer> list, int[] candidates, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(i + 1, sum + candidates[i], list, candidates, target);
            list.remove(list.size() - 1);
        }
    }
}