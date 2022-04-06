import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t47 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t47 {
    ArrayList<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    void backtracking(int[] nums, boolean[] visited, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backtracking(nums, visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}