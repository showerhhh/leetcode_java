import java.util.ArrayList;
import java.util.List;

public class t46 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t46 {
    ArrayList<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> tmp = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums, 0);
        return result;
    }

    void dfs(int[] nums, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!used[j]) {
                tmp.add(nums[j]);
                used[j] = true;
                dfs(nums, depth + 1);
                used[j] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}