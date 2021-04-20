import java.util.ArrayList;

public class t503 {
    public static void main(String[] args) {
        int[] num = {2, 3, 1};
        Solution_t503 solution = new Solution_t503();
        int[] result = solution.nextGreaterElements(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution_t503 {
    public int[] nextGreaterElements(int[] nums) {
        ArrayList<Integer> stack = new ArrayList<Integer>();  // 存下标
        int n = nums.length;
        int[] result = new int[nums.length];
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.get(stack.size() - 1)]) {
                int index = stack.remove(stack.size() - 1);
                result[index] = nums[i % n];
            }
            stack.add(i % n);
        }
        return result;
    }
}