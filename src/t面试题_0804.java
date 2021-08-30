import java.util.ArrayList;
import java.util.List;

public class t面试题_0804 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t面试题_0804 {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), res, nums);
        return res;
    }

    void backtrack(int start, ArrayList<Integer> t, ArrayList<List<Integer>> res, int[] nums) {
        res.add(new ArrayList<>(t));
        for (int i = start; i < nums.length; i++) {
            t.add(nums[i]);
            backtrack(i + 1, t, res, nums);
            t.remove(t.size() - 1);
        }
    }
}