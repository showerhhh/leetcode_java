import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class t491 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 2, 2};
        Solution_t491 solution = new Solution_t491();
        solution.findSubsequences(nums);
    }
}

class Solution_t491 {
    HashSet<ArrayList<Integer>> set = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        ArrayList<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    void backtracking(int[] nums, int i, ArrayList<Integer> seq) {
        if (seq.size() >= 2) {
            set.add(new ArrayList<>(seq));
        }
        if (i == nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (seq.size() == 0) {
                seq.add(nums[j]);
                backtracking(nums, j + 1, seq);
                seq.remove(seq.size() - 1);
            } else {
                if (nums[j] >= seq.get(seq.size() - 1)) {
                    seq.add(nums[j]);
                    backtracking(nums, j + 1, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
}