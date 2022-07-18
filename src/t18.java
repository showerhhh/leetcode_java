import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t18 {
    public static void main(String[] args) {
        Solution_t18 solution = new Solution_t18();
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        solution.fourSum_2(nums, target);
    }
}

class Solution_t18 {
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {  // nums[i]大于目标值时，不用继续找了
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  // nums[i]去重
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > target) {  // nums[j]大于目标值时，不用继续找了
                    return res;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {  // nums[j]去重
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {  // nums[left]去重
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {  // nums[right]去重
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum_2(int[] nums, int target) {
        return nSum(nums, target, 4);
    }

    public List<List<Integer>> nSum(int[] nums, int target, int n) {
        Arrays.sort(nums);
        backtracking(nums, target, n, 0, 0, new ArrayList<>());
        return res;
    }

    void backtracking(int[] nums, int target, int n, int start, int sum, ArrayList<Integer> list) {
        if (n == 2) {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                long t = sum + nums[left] + nums[right];
                if (t < target) {
                    left++;
                } else if (t > target) {
                    right--;
                } else {
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {  // nums[left]去重
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {  // nums[right]去重
                        right--;
                    }
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                backtracking(nums, target, n - 1, i + 1, sum + nums[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}