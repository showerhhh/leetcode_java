import java.util.ArrayList;
import java.util.List;

public class t442 {
    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Solution_t442 {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int k = Math.abs(nums[i]);
            if (nums[k - 1] < 0) {
                list.add(k);
            } else {
                nums[k - 1] *= -1;
            }
        }
        return list;
    }
}