import java.util.ArrayList;
import java.util.List;

public class t448 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];  // 取反，既能表示idx位置已被使用，又能保留idx位置的原来的数字。
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}