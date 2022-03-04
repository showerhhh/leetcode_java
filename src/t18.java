import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t18 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t18 {
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
}