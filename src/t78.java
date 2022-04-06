import java.util.ArrayList;
import java.util.List;

public class t78 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t78 {
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, int idx, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        if (idx == nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}