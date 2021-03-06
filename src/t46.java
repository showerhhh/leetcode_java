import java.util.ArrayList;
import java.util.List;

public class t46 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t46 {
    ArrayList<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums, new boolean[nums.length], new ArrayList<>());
        return result;
    }

    void backtracking(int[] nums, boolean[] visited, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
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