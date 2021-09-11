import java.util.ArrayList;
import java.util.List;

public class t78 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t78 {
    ArrayList<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }

    void backtrack(int idx, ArrayList<Integer> list, int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(i + 1, list, nums);
            list.remove(list.size() - 1);
        }
    }
}