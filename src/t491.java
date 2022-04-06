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
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        return res;
    }

    void backtracking(int[] nums, int idx, ArrayList<Integer> list) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
            // 没有return;还要继续
        }
        if (idx == nums.length) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (!list.isEmpty() && nums[i] < list.get(list.size() - 1)) {  // 跳过不符合递增的数字（不是去重）
                continue;
            }
            if (set.contains(nums[i])) {  // 去重，因为不能排序，所以只能借助于set
                continue;
            }
            list.add(nums[i]);
            set.add(nums[i]);  // 更新去重集合
            backtracking(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    //    HashSet<ArrayList<Integer>> set = new HashSet<>();
    //
    //    public List<List<Integer>> findSubsequences(int[] nums) {
    //        backtracking(nums, 0, new ArrayList<>());
    //        ArrayList<List<Integer>> res = new ArrayList<>(set);
    //        return res;
    //    }
    //
    //    void backtracking(int[] nums, int i, ArrayList<Integer> seq) {
    //        if (seq.size() >= 2) {
    //            set.add(new ArrayList<>(seq));
    //        }
    //        if (i == nums.length) {
    //            return;
    //        }
    //        for (int j = i; j < nums.length; j++) {
    //            if (seq.size() == 0) {
    //                seq.add(nums[j]);
    //                backtracking(nums, j + 1, seq);
    //                seq.remove(seq.size() - 1);
    //            } else {
    //                if (nums[j] >= seq.get(seq.size() - 1)) {
    //                    seq.add(nums[j]);
    //                    backtracking(nums, j + 1, seq);
    //                    seq.remove(seq.size() - 1);
    //                }
    //            }
    //        }
    //    }
}